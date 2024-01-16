package com.damsko.microblog.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class WelcomeController {

    @GetMapping("/")
    public String showWelcomePage() {
        return "welcome";
    }
}
