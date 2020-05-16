package com.gstu.controller;

import com.gstu.entity.User;
import com.gstu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService service;

    @GetMapping
    public String loginPage(Model model) {
        model.addAttribute("userForm", new User());
        return "login";
    }

    @PostMapping
    public ModelAndView addUser(@ModelAttribute("userForm") @Valid User userForm, Errors errors) {
        ModelAndView modelAndView = new ModelAndView();
        User user = service.getUserByUserName(userForm.getUsername());

        if (errors.hasErrors() || user == null || !user.getPassword().equals(userForm.getPassword())) {
            modelAndView.setViewName("login");
        } else {
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }
}
