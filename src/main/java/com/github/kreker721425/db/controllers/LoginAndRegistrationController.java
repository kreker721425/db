package com.github.kreker721425.db.controllers;

import com.github.kreker721425.db.models.Role;
import com.github.kreker721425.db.models.User;
import com.github.kreker721425.db.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;

@Controller
public class LoginAndRegistrationController {

    private final UserRepository userRepository;

    public LoginAndRegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("registration")
    public String registration(Model model){
        model.addAttribute("roles", Role.values());
        return "registration";
    }


    //НЕ РАБОТАЕТ ПЕРЕДАЧА CHECKBOX
    @PostMapping("registration")
    public String addUser(User user,
                          @RequestParam(value = "ADMIN", required = false) String adminRole,
                          @RequestParam(value = "USER", required = false) String userRole,
                          Model model
    ){
        User userInDB = userRepository.findByUsername(user.getUsername());

        if (userInDB != null) {
            model.addAttribute("messageErr","Такой логин уже существует");
            return "registration";
        }

        Set<Role> set = new HashSet<>();
        if (adminRole != null) set.add(Role.ADMIN);
        if (userRole != null) set.add(Role.USER);

        user.setRoles(set);
        user.setActive(true);

        userRepository.save(user);
        return "redirect:/user";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @PostMapping("login")
    public String signIn(User user, Model model){
        User userInDB = userRepository.findByUsername(user.getUsername());
        if (userInDB != null  && userInDB.getPassword().equals(user.getPassword())) {
            /*if (user.isActive()) {
                model.addAttribute("messageErr", "Пользователь уже активен"); //не работает
                return "login";
            }
            user.setActive(true);*/
            return "redirect:table";
        }
        else {
            model.addAttribute("messageErr", "Неправильно введен логин или пароль"); //не работает
            return "login";
        }
    }
}
