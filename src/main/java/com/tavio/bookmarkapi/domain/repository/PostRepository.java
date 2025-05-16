package com.tavio.bookmarkapi.domain.repository;

import com.tavio.bookmarkapi.persistance.entity.Post;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findByIdUserOrderByIdAsc(int idUser);

    Optional<Post> findByIdUserAndIdBook(int idUser, int idBook);

}
