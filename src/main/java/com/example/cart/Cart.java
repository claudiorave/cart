package com.example.cart;

import lombok.Data;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity

public class Cart {
	private @Id @GeneratedValue Long id;
	private ArrayList<Product> productList;
	private boolean finished = false;
	private double price = 0.0;

	public void addProductPrice(Product product) {
		this.price += product.getPrice() * product.getQuantity();
	}

	public void substractProductPrice(Product product) {
		this.price += product.getPrice();
	}

	public double getTotalPrice(ArrayList<Product> productList) {
		double sum = 0;
		for (int i = 0; i < productList.size(); i++) {
			Product product = productList.get(i);
			sum += product.getPrice();
		}
		return sum;
	}

	public Cart() {
		super();
	}

	public void addProduct(Product product) {
		Product prod = productList.stream().filter(productFromList -> product.getId().equals(productFromList.getId()))
				.findAny().orElse(null);
		if (prod != null) {
			prod.addQuantity(product.getQuantity());
		} else {
			productList.add(product);
		}

	}

	public void deleteProduct(Product product) {
		productList.remove(product);
	}

	public void checkout() {
		this.finished = true;

	}

}
