package com.tavio.bookmarkapi.domain.service;

import com.tavio.bookmarkapi.domain.repository.PostRepository;
import com.tavio.bookmarkapi.persistance.entity.Book;
import com.tavio.bookmarkapi.persistance.entity.Post;
import com.tavio.bookmarkapi.persistance.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    public List<Post> getAll(){
        return (List<Post>) postRepository.findAll();
    }

    public List<Post> getByUser(Long idUser){
        return  postRepository.findByIdUserOrderByIdAsc(idUser);
    }


    public Optional<Post> getPost(Long idPost){
        return postRepository.findById(idPost);
    }

    public void save(Post post){
        postRepository.save(post);
    }

    public Optional<Post> getPostByUsernameAndBookNameAndNumPost(String username, String bookName, int numPost){
        UserEntity user = userService.getByUsername(username).get();
        Book book = bookService.getByName(bookName).get();
        return postRepository.findByIdUserAndIdBook(user.getId(), book.getId());
    }
    public boolean delete(Long idPost){
        return getPost(idPost).map(post ->{
            postRepository.deleteById(idPost);
            return true;
        }).orElse(false);
    }

}
