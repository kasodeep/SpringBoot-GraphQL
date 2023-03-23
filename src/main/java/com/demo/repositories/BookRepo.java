package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

}
