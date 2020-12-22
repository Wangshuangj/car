package com.example.car.controller;

import com.example.car.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @Autowired
    CustomUserDetailsService userDetailsService;

    @RequestMapping("/toLogin")
    public String goLogin() {
        return "login";
    }

    @RequestMapping("/admin")
    public String goAdmin() {
        return "views/page1";
    }

    @RequestMapping("/user")
    public String goUser() {
        return "views/page2";
    }

}
