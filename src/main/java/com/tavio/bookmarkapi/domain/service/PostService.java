package com.tavio.bookmarkapi.domain.service;

import com.tavio.bookmarkapi.domain.repository.PostRepository;
import com.tavio.bookmarkapi.persistance.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAll(){
        return (List<Post>) postRepository.findAll();
    }

    public List<Post> getByUser(int idUser){
        return  postRepository.findByIdUserOrderByIdAsc(idUser);
    }


    public Optional<Post> getPost(BigInteger idPost){
        return postRepository.findById(idPost);
    }

    public void save(Post post){
        postRepository.save(post);
    }
    public boolean delete(BigInteger idPost){
        return getPost(idPost).map(post ->{
            postRepository.deleteById(idPost);
            return true;
        }).orElse(false);
    }

}
