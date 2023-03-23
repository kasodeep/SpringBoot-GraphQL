package com.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Books")
public class Book {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    
	    private String title;
	    
	    private String description;
	    
	    private double price;
	    
	    private Integer pages;
	    
	    @JoinColumn
	    @ManyToOne(cascade = CascadeType.PERSIST)
	    private Author author;
}
