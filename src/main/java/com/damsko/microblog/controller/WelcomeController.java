package com.damsko.microblog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @GetMapping("/")
    public String showWelcomePage() {
        if (logger.isDebugEnabled()){
            logger.debug("Showing Welcome page");
        }
        logger.info("Showing Welcome page");
        return "welcome";
    }
}
