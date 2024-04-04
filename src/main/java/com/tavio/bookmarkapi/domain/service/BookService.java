package com.tavio.bookmarkapi.domain.service;

import com.tavio.bookmarkapi.persistance.BookRepository;
import com.tavio.bookmarkapi.persistance.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAll(){
        return bookRepository.getAll();
    }
    public void save(Book book){
        bookRepository.save(book);
    }

    public boolean delete(int idBook){
        return getBook(idBook).map(book -> {
            bookRepository.delete(idBook);
            return true;
        }).orElse(false);

    }
    public Optional<Book> getBook(int idBook){
        return bookRepository.getBook(idBook);
    }
}
