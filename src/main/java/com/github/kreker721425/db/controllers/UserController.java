package com.github.kreker721425.db.controllers;

import com.github.kreker721425.db.models.Role;
import com.github.kreker721425.db.models.User;
import com.github.kreker721425.db.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user_list";
    }

    @GetMapping("/user_edit/{user}")
    public String userEdit(@PathVariable User user, Model model) {
        model.addAttribute("user",user);
        model.addAttribute("roles", Role.values());
        return "user_edit";
    }

    @PostMapping
    public String userSave(@RequestParam("userId") User user,
                           @RequestParam Map<String, String> form,
                           @RequestParam String username,
                           @RequestParam String password
    ) {
        user.setUsername(username);
        user.setPassword(password);
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key: form.keySet()){
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userService.save(user);

        return "redirect:/user";
    }

    @GetMapping("delete/{user}")
    public String userDelete(@PathVariable User user) {
        userService.delete(user);
        return "redirect:/user";
    }
}
