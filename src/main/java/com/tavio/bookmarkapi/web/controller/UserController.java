package com.tavio.bookmarkapi.web.controller;

import com.tavio.bookmarkapi.domain.service.UserService;
import com.tavio.bookmarkapi.persistance.entity.Post;
import com.tavio.bookmarkapi.persistance.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/save")
    public void save(@RequestBody User user){
        userService.save(user);
    }
}
