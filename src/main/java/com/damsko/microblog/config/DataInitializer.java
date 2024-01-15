package com.damsko.microblog.config;

import com.damsko.microblog.model.User;
import com.damsko.microblog.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        User user1 = new User("john_doe", "password123");
        User user2 = new User("jane_doe", "securePassword");

        userRepository.save(user1);
        userRepository.save(user2);

    }
}
