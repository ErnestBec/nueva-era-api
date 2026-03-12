package com.nuevaera.api.controller;

import com.nuevaera.api.dto.UserDTO;
import com.nuevaera.api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //save
    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO) {
        System.out.println("Usuario registrar: " + userDTO.toString());
        return new ResponseEntity<>(userService.save(userDTO), HttpStatus.CREATED);
    }
}
