package com.example.cart;

import lombok.Data;

import javax.persistence.Entity;


@Data
@Entity
public class CartDTO {
	
	private double price;
	
	public CartDTO() {
		super();
	}
	
	public CartDTO(double price) {
		super();
		this.price=price;
	}

}
