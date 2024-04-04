package com.tavio.bookmarkapi.web.controller;

import com.tavio.bookmarkapi.domain.service.BookService;
import com.tavio.bookmarkapi.persistance.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public List<Book> getAll(){
        return bookService.getAll();
    }
    @PostMapping("/save")
    public void save(@RequestBody Book book){
        bookService.save(book);
    }

    @DeleteMapping("/delete/id")
    public boolean delete(@PathVariable("id") int idBook){
        return bookService.delete(idBook);
    }
    @GetMapping("/{id}")
    public Optional<Book> getBook(@PathVariable("id") int idBook){
        return bookService.getBook(idBook);
    }
}
