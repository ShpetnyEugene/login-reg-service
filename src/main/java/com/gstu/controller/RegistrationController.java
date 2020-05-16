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
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping
    public ModelAndView addUser(@ModelAttribute("userForm") @Valid User userForm, Errors errors) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");

        boolean isSave = userService.saveUser(userForm);

        if (errors.hasErrors() || !userForm.getPassword().equals(userForm.getRepeatPassword())) {

            modelAndView.addObject("message", "Please, check input fields!");
            return modelAndView;
        } else if (!isSave) {
            modelAndView.addObject("message", "User with such name already exists! Please choose another.");
        } else {
            modelAndView.setViewName("redirect:/login");
        }

        return modelAndView;
    }
}
