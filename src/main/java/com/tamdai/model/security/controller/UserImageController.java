package com.tamdai.model.security.controller;

import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.security.entity.UserImage;
import com.tamdai.model.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;

/**
 * Created by Dto on 3/29/2016.
 */
@CrossOrigin
@Controller
@RequestMapping("/")
public class UserImageController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "add/ImageUser", method = RequestMethod.POST)
    @ResponseBody
    public UserEntity addImage(HttpServletRequest request,
                               HttpServletResponse response, @RequestParam("userId") Long userId) {
        MultipartHttpServletRequest mRequest;
        UserEntity userEntity = userService.getUserId(userId);

        try {
            mRequest = (MultipartHttpServletRequest) request;
            Iterator<String> itr = mRequest.getFileNames();
            while (itr.hasNext()) {
                MultipartFile multipartFile = mRequest.getFile(itr.next());
                UserImage image = new UserImage();
                image.setFileName(multipartFile.getOriginalFilename());
                image.setContentType(multipartFile.getContentType());
                image.setContent(multipartFile.getBytes());
                userService.addUserImage(userEntity, image);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userEntity;
    }

    @RequestMapping(value = "delete/ImageUser", method = RequestMethod.DELETE)
    @ResponseBody
    public UserEntity deleteImageUser(@RequestParam("imageId") Long imageId, @RequestParam("userId") Long userId) {
        UserEntity userEntity = userService.getUserId(userId);
        return userService.deleteImageUser(userEntity, imageId);
    }
}
