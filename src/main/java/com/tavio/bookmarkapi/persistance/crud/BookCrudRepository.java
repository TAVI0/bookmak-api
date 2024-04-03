package com.tavio.bookmarkapi.persistance.crud;

import com.tavio.bookmarkapi.persistance.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookCrudRepository extends CrudRepository<Book, Integer> {
}
