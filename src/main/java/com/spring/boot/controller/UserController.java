package com.spring.boot.controller;

import com.spring.boot.entity.UserEntity;
import com.spring.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try{
            if(userRepository.findByLogin(user.getLogin()) != null){
                return ResponseEntity.badRequest().body("User with such login already exist");
            }
            userRepository.save(user);
            return ResponseEntity.ok("User saved");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Failed to get all users");

        }
    }
    @GetMapping
    public ResponseEntity getUsers(){
        try{
            return ResponseEntity.ok("Server works");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Failed to get all users");

        }
    }
}
