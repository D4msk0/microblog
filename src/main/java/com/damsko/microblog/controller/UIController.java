package com.damsko.microblog.controller;

import com.damsko.microblog.model.User;
import com.damsko.microblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui/users")
public class UIController {

    private final UserService userService;

    @Autowired
    public UIController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("user") User user, Model model) {
        userService.createUser(user);
        model.addAttribute("registrationComplete", true);
        return "redirect:/ui/users/thankyou";
    }

    @GetMapping("/thankyou")
    public String showThankYouPage() {
        return "thankyou";
    }
}
