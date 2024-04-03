package com.tavio.bookmarkapi.persistance;

import com.tavio.bookmarkapi.persistance.crud.BookCrudRepository;
import com.tavio.bookmarkapi.persistance.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {
    private BookCrudRepository bookCrudRepository;

    public List<Book> getAll(){
        return (List<Book>) bookCrudRepository.findAll();
    }
    public Book save(Book book){
        return bookCrudRepository.save(book);
    }
    public void delete(int idBook){
        bookCrudRepository.deleteById(idBook);
    }
}
