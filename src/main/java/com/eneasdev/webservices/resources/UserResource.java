package com.eneasdev.webservices.resources;

import com.eneasdev.webservices.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1l, "Mateus", "mateus@gmail.com", "9999-9999", "12345");
        return ResponseEntity.ok().body(u);
    }
}
