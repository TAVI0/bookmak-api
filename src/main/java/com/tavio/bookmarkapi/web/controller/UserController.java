package com.tavio.bookmarkapi.web.controller;

import com.tavio.bookmarkapi.domain.service.UserService;
import com.tavio.bookmarkapi.persistance.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }
    @GetMapping("/id/{id}")
    public Optional<User> getById(@PathVariable("id") Integer idUser){
        return userService.getById(idUser);
    }
    @GetMapping("/username/{username}")
    public Optional<User> getByUsername(@PathVariable("username") String username){
        return userService.getByUsername(username);
    }
}
