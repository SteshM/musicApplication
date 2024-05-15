package com.example.myMusicApp.controller;

import com.example.myMusicApp.DTOs.ResponseDTO;
import com.example.myMusicApp.DTOs.UserDTO;
import com.example.myMusicApp.services.UserService;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1")
public class UserController {
@Autowired
UserService userService;

@PostMapping("/user")
    public ResponseDTO createUser(@RequestBody UserDTO userDTO){
    return userService.createUser(userDTO);
}
}
