package com.demo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Author;
import com.demo.repositories.AuthorRepo;
import com.demo.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepo authorRepo;

	@Override
	public Author create(Author author) {
		return this.authorRepo.save(author);
	}

	@Override
	public List<Author> getAll() {
		return this.authorRepo.findAll();
	}

	@Override
	public Author get(int authorId) {
		return this.authorRepo.findById(authorId)
				.orElseThrow(() -> new RuntimeException("Author you are looking for not found on server !!"));
	}

	@Override
	public Author update(Author author) {
		return this.authorRepo.saveAndFlush(author);
	}

	@Override
	public void delete(int authorId) {
		this.authorRepo.deleteById(authorId);
	}

}
