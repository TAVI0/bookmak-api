package com.tavio.bookmarkapi.domain.repository;

import com.tavio.bookmarkapi.persistance.crud.PostCrudRepository;
import com.tavio.bookmarkapi.persistance.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {
    @Autowired
    private PostCrudRepository postCrudRepository;

    public List<Post> getAll(){
        return (List<Post>) postCrudRepository.findAll();
    }
    public List<Post> getByUser(int idUser){
        return postCrudRepository.findByIdUserOrderByIdAsc(idUser);
    }
    public Optional<Post> getPost(BigInteger idPost){
        return postCrudRepository.findById(idPost);
    }
    public void save(Post post){
        postCrudRepository.save(post);
    }
    public void delete(BigInteger idPost){
        postCrudRepository.deleteById(idPost);
    }

}
