/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bookservicedb;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Senith Umesha
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
    
    @Query("SELECT b FROM Book b WHERE b.book_name= ?1")
    Optional<Book> getBookName(String book_name);
    
    @Query("SELECT b FROM Book b WHERE b.book_author= ?1")
    Optional<Book> getBookAuthor(String book_author);
}
