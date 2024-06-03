package com.tavio.bookmarkapi.web.controller;

import com.tavio.bookmarkapi.domain.service.UserService;
import com.tavio.bookmarkapi.persistance.entity.User;
import com.tavio.bookmarkapi.persistance.entity.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
 /*   @Autowired
    private PasswordEncoder passwordEncoder;
*/
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

    @GetMapping("/userexist/{username}")
    public boolean getUserExistByUsername(@PathVariable("username") String username){
        return userService.getByUsername(username).isPresent();
    }
    @PostMapping("/save")
    public void save(@RequestBody User user){
        //    String encryptedPassword = passwordEncoder.encode(user.getPassword());
        //   user.setPassword(encryptedPassword);
        userService.save(user);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user){
        //    String encryptedPassword = passwordEncoder.encode(user.getPassword());
        //   user.setPassword(encryptedPassword);
        userService.save(user);
    }
    @PostMapping("/login")
    public Optional<UserResponse> login(@RequestBody User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(1L);
        userResponse.setUsername("TAVI0");
        userResponse.setAccessToken("tokenDeAccesso");
        userResponse.setRefreshToken("tokendeRefresco?(?");
        return Optional.of(userResponse);
    }
}
