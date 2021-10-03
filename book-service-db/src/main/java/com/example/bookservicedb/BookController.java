/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bookservicedb;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Senith Umesha
 */

@RestController
public class BookController {
    
    @Autowired
    private BookRepository bookRepository;
 
    @GetMapping(path = "/books")
    public List<Book> getAllBooks(){ 
        List<Book> booklist = bookRepository.findAll();
        return booklist;
    }
    
    @GetMapping(path = "/books/name/{book_name}")
    public Book findBookByName(@PathVariable(value = "book_name") String book_name){ 
        Optional<Book> book = bookRepository.getBookName(book_name);
        if(book.isPresent()){
            return book.get();
        }
        return null;
    }
    
    @GetMapping(path = "/books/author/{book_author}")
    public Book findBookByAuthor(@PathVariable(value = "book_author") String book_author){ 
        Optional<Book> book = bookRepository.getBookAuthor(book_author);
        if(book.isPresent()){
            return book.get();
        }
        return null;
    }
}

