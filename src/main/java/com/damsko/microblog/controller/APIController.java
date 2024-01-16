package com.damsko.microblog.controller;

import com.damsko.microblog.model.User;
import com.damsko.microblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class APIController {

    private final UserService userService;

    @Autowired
    public APIController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

//    @PostMapping("/register")
//    public String processRegistration(@ModelAttribute("user") User user) {
//        userService.createUser(user);
//        return "redirect:/ui/register";
//    }

}
