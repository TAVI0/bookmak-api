package com.tavio.bookmarkapi.web.controller;

import com.tavio.bookmarkapi.domain.service.PostService;
import com.tavio.bookmarkapi.domain.service.UserService;
import com.tavio.bookmarkapi.persistance.entity.Post;
import com.tavio.bookmarkapi.persistance.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<Post> getAll(){
        return postService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Post> getPost(@PathVariable("id") BigInteger idPost){
        return postService.getPost(idPost);
    }
    @GetMapping("/userid/{id}")
    public List<Post> getByUserid(@PathVariable("id") int idUser){
        return postService.getByUser(idUser);
    }

    @GetMapping("/username/{username}")
    public List<Post> getByUsername(@PathVariable("username") String username){
        Optional<User> user = userService.getByUsername(username);
        return user.map(value -> postService.getByUser(value.getId())).orElse(null);
    }

    @PostMapping("/save")
    public void save(@RequestBody Post post){
        postService.save(post);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") BigInteger idPost){
        return postService.delete(idPost);
    }

}
