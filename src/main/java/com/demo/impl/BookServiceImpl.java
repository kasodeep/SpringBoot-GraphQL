package com.demo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Book;
import com.demo.repositories.BookRepo;
import com.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepo bookRepo;
	
	@Override
	public Book create(Book book) {
		return this.bookRepo.save(book);
	}

	@Override
	public List<Book> getAll() {
		return this.bookRepo.findAll();
	}

	@Override
	public Book get(int bookId) {
		return this.bookRepo.findById(bookId)
				.orElseThrow(() -> new RuntimeException("Book you are looking for not found on server !!"));
	}

	@Override
	public Book update(Book book) {
		return this.bookRepo.saveAndFlush(book);
	}

	@Override
	public void delete(int bookId) {
		 this.bookRepo.deleteById(bookId);
	}

}
