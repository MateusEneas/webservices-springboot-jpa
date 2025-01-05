package com.eneasdev.webservices.config;

import com.eneasdev.webservices.entities.User;
import com.eneasdev.webservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Mateus Eneas", "mateus@gmail.com","99999999", "12345");
        User u2 = new User(null, "Eliza Maciel", "eliza@gmail.com", "77777777", "98765");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
