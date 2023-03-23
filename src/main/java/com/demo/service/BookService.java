package com.demo.service;

import java.util.List;

import com.demo.entities.Book;

public interface BookService {
	  
	//Create
    Book create(Book book);

    //Get all
    List<Book> getAll();

    //Get single book
    Book get(int bookId);
    
    //Update Book
    Book update(Book book);
    
    //Delete Book
    void delete(int bookId); 
}
