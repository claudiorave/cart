package com.example.cart;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data //AUTO-GENERATES GETTERS, SETTERS
@Entity
class Product {



	private @Id Long id;
	private String title;
	private Double price;
	
	public Product() {
		super();
	}
	
	public Product(Long id, String title, Double price) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
	}
	
	}
