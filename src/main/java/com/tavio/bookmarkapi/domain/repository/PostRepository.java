package com.tavio.bookmarkapi.domain.repository;

import com.tavio.bookmarkapi.persistance.entity.Post;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface PostRepository extends CrudRepository<Post, BigInteger> {
    List<Post> findByIdUserOrderByIdAsc(int idUser);

}
