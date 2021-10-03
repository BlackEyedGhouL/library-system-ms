/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.userwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Senith Umesha
 */

@Controller
public class UserController {
    
    private final static String BASE_URL = "http://localhost:8082";
    
    @GetMapping(path = "/log-in")
    public String getLogIn(ModelMap model) {
        model.addAttribute("user", new User());
        return "log_in.jsp";
    }

    @PostMapping(path = "/log-in")
    public String findUserByNameAndPassword(ModelMap model, @ModelAttribute User user) {
        RestTemplate restTemplate = new RestTemplate(); 
        String response = restTemplate.getForObject("http://localhost:8082/users/{name}/{password}", String.class,user.getName(),user.getPassword());
        if (response != null) {
            model.addAttribute("name",user.getName());
            return "dashboard.jsp"; 
        }
        else{
            model.addAttribute("test", "Incorrect name or password, Please try again!");
            return "log_in.jsp";}
    }
    
    @GetMapping(path = "/create-user")
    public String getCreateUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "create_user.jsp";
    }
    
    @PostMapping(path = "/create-user")
    public String createUser(ModelMap model, @ModelAttribute User user) {
        RestTemplate restTemplate = new RestTemplate();
        User createdUser = restTemplate.postForObject(BASE_URL + "/users",user, User.class);
        model.addAttribute("user", createdUser);
        model.addAttribute("name",user.getName());
        return "dashboard.jsp";
    }
    
    @GetMapping(path = "/delete-user")
    public String getDeleteUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "delete_user.jsp";
    }

    @PostMapping(path = "/delete-user")
    public String deleteUser(ModelMap model, @ModelAttribute User user) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(BASE_URL + "/users?name="+user.getName());
        return "log_in.jsp";
    }
    
    @GetMapping(path = "/edit-user")
    public String getEditUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "edit_user.jsp";
    }
    
    @PostMapping(path = "/edit-user")
    public String editUser(ModelMap model, @ModelAttribute User user) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(BASE_URL + "/users/"+user.getId(),user);
        model.addAttribute("user", user);
        return "log_in.jsp";
    }
}
