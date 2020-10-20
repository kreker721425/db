package com.github.kreker721425.db.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class UploadUtils {

    public static boolean uploadFile(String uploadPath, MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            File uploadFile = new File(uploadPath);
            if (!uploadFile.exists()) {
                uploadFile.mkdir();
            }

            //Присваивание шифра
            /*String uuid = UUID.randomUUID().toString();
            String resultFileName = uuid + "." + file.getOriginalFilename();*/
            String resultFileName = uploadFile + "/" + file.getOriginalFilename();

            file.transferTo(new File(resultFileName));
            return true;
        } else
            return false;
    }
}
