package com.tavio.bookmarkapi.domain.repository;

import com.tavio.bookmarkapi.persistance.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
