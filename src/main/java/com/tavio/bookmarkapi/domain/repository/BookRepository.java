package com.tavio.bookmarkapi.domain.repository;

import com.tavio.bookmarkapi.persistance.crud.BookCrudRepository;
import com.tavio.bookmarkapi.persistance.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {
    @Autowired
    private BookCrudRepository bookCrudRepository;

    public List<Book> getAll(){
        return (List<Book>) bookCrudRepository.findAll();
    }
    public void save(Book book){
        bookCrudRepository.save(book);
    }
    public void delete(int idBook){
        bookCrudRepository.deleteById(idBook);
    }
    public Optional<Book> getBook(int idBook){
        return bookCrudRepository.findById(idBook);
    }
}