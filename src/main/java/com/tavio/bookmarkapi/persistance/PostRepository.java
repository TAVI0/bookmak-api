package com.tavio.bookmarkapi.persistance;

import com.tavio.bookmarkapi.persistance.crud.PostCrudRepository;
import com.tavio.bookmarkapi.persistance.entity.Post;

import java.util.List;

public class PostRepository {
    private PostCrudRepository postCrudRepository;

    public List<Post> getAll(){
        return (List<Post>) postCrudRepository.findAll();
    }
    public List<Post> getByUser(int idUser){
        return postCrudRepository.findByIdUserOrderByIdAsc(idUser);
    }
}
