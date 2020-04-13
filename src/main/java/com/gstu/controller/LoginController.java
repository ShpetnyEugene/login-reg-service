package com.gstu.controller;

import com.gstu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService service;

    @GetMapping
    public String loginPage(Model model){
        return "login";
    }
}
