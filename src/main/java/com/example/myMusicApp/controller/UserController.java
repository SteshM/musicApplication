package com.example.myMusicApp.controller;

import com.example.myMusicApp.DTOs.ResponseDTO;
import com.example.myMusicApp.DTOs.UserDTO;
import com.example.myMusicApp.services.UserService;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@GetMapping("/users")
    public ResponseDTO fetchUsers(){
    return userService.fetchUsers();
}
@GetMapping("/user/{id}")
    public ResponseDTO fetchUserById(@PathVariable int id){
    return userService.fetchUserById(id);
}
@PutMapping("/user/{id}")
    public ResponseDTO updateUser(@RequestBody UserDTO userDTO , @PathVariable int id){
    return userService.updateUserById(userDTO,id);

}
    @DeleteMapping("/delete/{id}")
    public ResponseDTO deleteUser(@PathVariable int id){
    return userService.deleteUserById(id);
    }
}
