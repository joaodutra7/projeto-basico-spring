package com.projetospring.userdept.controllers;

import com.projetospring.userdept.entities.User;
import com.projetospring.userdept.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> userList(){
        List<User> result = repository.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public User userById(@PathVariable Long id){
        User result = repository.findById(id).get();
        return result;
    }

    @PostMapping
    public User insertUser(@RequestBody User user){
        User result = repository.save(user);
        return result;
    }


}
