package com.tavio.bookmarkapi.domain.service;

import com.tavio.bookmarkapi.domain.repository.BookRepository;
import com.tavio.bookmarkapi.persistance.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll(){
        return (List<Book>) bookRepository.findAll();
    }
    public Optional<Book> getByName(String name){
        return bookRepository.getByName(name);
    }
    public void save(Book book){
        bookRepository.save(book);
    }

    public boolean delete(int idBook){
        return getBook(idBook).map(book -> {
            bookRepository.deleteById(idBook);
            return true;
        }).orElse(false);

    }
    public Optional<Book> getBook(int idBook){
        return bookRepository.findById(idBook);
    }
}
