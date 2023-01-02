package com.kitchen.www.controller;

import com.kitchen.www.entities.User;
import com.kitchen.www.inputs.PaginationInput;
import com.kitchen.www.inputs.UserInput;
import com.kitchen.www.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUserById")
    public User getUserById(@RequestParam String id){
        User tempUser= userService.getUserById(id);
        return tempUser;
    }

    @GetMapping("/getUserByUsername")
    public User getUserByUsername(@RequestParam String name){
        User tempUser = userService.getUserByUsername(name);
        return tempUser;
    }

    @GetMapping("/getAllUsers")
    public Page<User> getAllUser(@RequestBody PaginationInput paginationInput){
        return userService.getAllUser(paginationInput);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody UserInput userInput){
        return userService.addUser(userInput);
    }

    @PostMapping("/updateUser")
    public User updateUser(@RequestBody UserInput userInput){
        return userService.updateUser(userInput);
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam String id){
        return userService.deleteUser(id);
    }

}
