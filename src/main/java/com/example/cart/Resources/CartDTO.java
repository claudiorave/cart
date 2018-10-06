package com.example.cart.Resources;

import lombok.Data;

import javax.persistence.Id;

@Data
public class CartDTO {
	private @Id Long id;
	private double price;

	public CartDTO() {
		super();
	}

	public CartDTO(double price, Long id) {
		super();
		this.price = price;
		this.id = id;
	}

}
