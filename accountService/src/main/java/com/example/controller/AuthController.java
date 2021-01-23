package com.example.controller;

import com.example.dto.CreateUserDto;
import com.example.exception.UserAlreadyExistsException;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/user")
    public ResponseEntity<?> createAccount(@RequestBody CreateUserDto userData) {
        try {
            userService.createUser(userData);
        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Successful account creation ", HttpStatus.OK);
    }

    @GetMapping(path = "/test")
    public ResponseEntity<?> test() {
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }
}
