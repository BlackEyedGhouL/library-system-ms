/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.userwebapp;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Senith Umesha
 */

@Controller
public class BookController {
    
    private final static String BASE_URL = "http://localhost:8084";   
    
    @GetMapping(path = "/all-books")
    public String getAllBooks(ModelMap model) {
        model.addAttribute("book", new Book());
        return "all_books.jsp";
    }
    
    @PostMapping(path = "/all-books")
    public String AllBooks(ModelMap model){
        RestTemplate restTemplate = new RestTemplate();
        List<Book> booklist = restTemplate.getForObject(BASE_URL + "/books", List.class);
            model.addAttribute("searchedBook", booklist);
        return "all_books.jsp";
    }
    
    @GetMapping(path = "/search-books-name")
    public String getBooksByName(ModelMap model) {
        model.addAttribute("book", new Book());
        return "search_books_name.jsp";
    }

    @PostMapping(path = "/search-books-name")
    public String getBooksByName(ModelMap model, @ModelAttribute Book book) {
        RestTemplate restTemplate = new RestTemplate();
        Book searchedBook = restTemplate.getForObject(BASE_URL + "/books/name/" + book.getBook_name(), Book.class);
        if (searchedBook != null) {
            model.addAttribute("searchedBook", searchedBook);
        }
        return "search_books_name.jsp";
    }
    
    @GetMapping(path = "/search-books-author")
    public String getBooksByAuthor(ModelMap model) {
        model.addAttribute("book", new Book());
        return "search_books_author.jsp";
    }

    @PostMapping(path = "/search-books-author")
    public String getBooksByAuthor(ModelMap model, @ModelAttribute Book book) {
        RestTemplate restTemplate = new RestTemplate();
        Book searchedBook = restTemplate.getForObject(BASE_URL + "/books/author/" + book.getBook_author(), Book.class);
        if (searchedBook != null) {
            model.addAttribute("searchedBook", searchedBook);
        }
        return "search_books_author.jsp";
    }
}
