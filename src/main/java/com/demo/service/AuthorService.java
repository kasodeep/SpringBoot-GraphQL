package com.demo.service;

import java.util.List;

import com.demo.entities.Author;

public interface AuthorService {
	
	//Create
    Author create(Author author);

    //Get all
    List<Author> getAll();

    //Get single book
    Author get(int authorId);
    
    //Update Author
    Author update(Author author);
    
    //Delete Author
    void delete(int authorId);
	
}
