package com.tavio.bookmarkapi.web.controller;

import com.tavio.bookmarkapi.domain.service.BookService;
import com.tavio.bookmarkapi.domain.service.PostService;
import com.tavio.bookmarkapi.domain.service.UserService;
import com.tavio.bookmarkapi.persistance.entity.Post;
import com.tavio.bookmarkapi.persistance.entity.UserEntity;
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
    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public List<Post> getAll(){
        return postService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Post> getPost(@PathVariable("id") Long idPost){
        return postService.getPost(idPost);
    }
    @GetMapping("/userid/{id}")
    public List<Post> getByUserid(@PathVariable("id") Long idUser){
        return postService.getByUser(idUser);
    }

    @GetMapping("/{username}/{bookName}/{num}")
    public Optional<Post> getPostByUserBookNameNum(@PathVariable("username") String username, @PathVariable("bookName") String bookName, @PathVariable("num") int num){
        String bookNameStr = bookName.replace("-"," ");
        return postService.getPostByUsernameAndBookNameAndNumPost(username,bookNameStr,1);
    }

    @GetMapping("/username/{username}")
    public List<Post> getByUsername(@PathVariable("username") String username){
        Optional<UserEntity> user = userService.getByUsername(username);
        return user.map(value -> postService.getByUser(value.getId())).orElse(null);
    }

    @PostMapping("/save")
    public void save(@RequestBody Post post){
        post.setBook(bookService.getBook(post.getIdBook()).get());
        post.setUserEntity(userService.getById(post.getIdUser()).get());
        postService.save(post);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Long idPost){
        return postService.delete(idPost);
    }

}
