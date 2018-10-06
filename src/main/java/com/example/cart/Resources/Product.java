package com.example.cart.Resources;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Product {

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
