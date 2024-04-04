package com.tavio.bookmarkapi.persistance;

import com.tavio.bookmarkapi.persistance.crud.PostCrudRepository;
import com.tavio.bookmarkapi.persistance.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PostRepository {
    private PostCrudRepository postCrudRepository;

    public List<Post> getAll(){
        return (List<Post>) postCrudRepository.findAll();
    }
    public List<Post> getByUser(int idUser){
        return postCrudRepository.findByIdUserOrderByIdAsc(idUser);
    }
}
