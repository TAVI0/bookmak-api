package com.tavio.bookmarkapi.persistance.crud;

import com.tavio.bookmarkapi.persistance.entity.Post;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface PostCrudRepository extends CrudRepository<Post, BigInteger> {

    List<Post> findByIdUserOrderByIdAsc(int idUser);

}
