/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.userservicedb;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Senith Umesha
 */

@RestController
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/users/{name}/{password}")
    public String findUserByNameAndPassword(@PathVariable(value = "name") String name,@PathVariable(value = "password") String password){        
        List<User> user = userRepository.findUserByNameAndPassword(name, password);
        if(user.isEmpty()){
            return null;
        }
        return "Success";
    }

    @PostMapping(path = "/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    
    @PutMapping(path = "/users/{userId}")
    public User updateUserById(@PathVariable int userId,
            @RequestBody User newUser) {
        Optional<User> userObj = userRepository.findById(userId);
        if (!userObj.isPresent()) {
            return null;
        }
        User user = userObj.get();
        if (newUser.getName() != null) {
            user.setName(newUser.getName());
        }
        if (newUser.getPassword()!= null) {
            user.setPassword(newUser.getPassword());
        }
        if (newUser.getAge() != 0) {
            user.setAge(newUser.getAge());
        }
        if (newUser.getAddress() != null) {
            user.setAddress(newUser.getAddress());
        }
        return userRepository.save(user);
    }
    
    @DeleteMapping(path = "/users")
    public void deleteUserByName(@RequestParam String name) {
         userRepository.deleteUserByName(name);    
    } 
    
}
