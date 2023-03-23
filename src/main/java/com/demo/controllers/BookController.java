package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.demo.entities.Author;
import com.demo.entities.Book;
import com.demo.service.AuthorService;
import com.demo.service.BookService;
import com.demo.util.BookInput;


@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;

	@QueryMapping("allBooks")
    public List<Book> getAll() {
        return this.bookService.getAll();
    }
	
	@MutationMapping("createBook")
	public Book create(@Argument BookInput book) {
    	
        Book b = new Book();
        Author author = this.authorService.get(book.getAuthor());
        
        b.setTitle(book.getTitle());
        b.setDescription(book.getDescription());
        b.setPrice(book.getPrice());
        b.setPages(book.getPages());
        b.setAuthor(author);
   
        return this.bookService.create(b);
    }
	
	@MutationMapping("updateBook")
    public Book update(@Argument BookInput book, @Argument int bookId) {
    	
    	Book temp = this.bookService.get(bookId);
    	Author author = this.authorService.get(book.getAuthor());
    	 
    	temp.setTitle(book.getTitle());
        temp.setDescription(book.getDescription());
        temp.setPrice(book.getPrice());
        temp.setPages(book.getPages());
        temp.setAuthor(author);
        
        return this.bookService.update(temp);
    }
	
	 @QueryMapping("getBook")
	 public Book get(@Argument int bookId) {
		 return this.bookService.get(bookId);
	}
	
	@QueryMapping("deleteBook")
	public String delete(@Argument int bookId) {
		
		this.bookService.delete(bookId);
		return "Book successfully deleted with Id: "+bookId;
	}
	
}
