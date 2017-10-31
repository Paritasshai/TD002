//package com.tamdai.model.config.security;
//
//import com.tamdai.model.security.entity.UserEntity;
//import com.tamdai.model.security.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
///**
// * Created by Dto on 4/19/2015.
// */
//@Component
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public UserDetails loadUserByUsername(String firstName) throws UsernameNotFoundException {
//        UserEntity user = userService.getUserByFirstName(firstName);
//        if(user == null){
//            throw new UsernameNotFoundException("User name" + firstName + "not found");
//        }
//        return new SecurityUser(user);
//    }
//}
