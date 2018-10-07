package com.example.cart.Resources;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class ProductPurchase {

	private @Id @GeneratedValue Long Id;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "pId")
	private Product product;
	private int quantity;

	public ProductPurchase() {
		super();
	}

	public ProductPurchase(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public void addQuantity(int n) {
		this.quantity += n;
	}

	public void substractQuantity(int n) {
		if ((this.quantity - n) < 0) {
			this.quantity = 0;
		} else {
			this.quantity -= n;
		}
	}
}
