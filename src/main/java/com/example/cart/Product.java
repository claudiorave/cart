package com.example.cart;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class Product {



	private @Id Long id;
	private String title;
	private Double price;
	
	public Product() {
		this.id = null;
		this.title = "";
		this.price = null;
	}
	
	public Product(Long id, String title, Double price) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
	}
	
	}
