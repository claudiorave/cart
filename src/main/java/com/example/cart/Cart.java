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
	private boolean finished=false;
	private double price;
	
	public double sumProducts(ArrayList<Product> productList) {
	    double sum = 0;
	    for (int i = 0; i < productList.size(); i++) {
	        Product product = productList.get(i);
	        sum += product.getPrice();
	    }
	    return sum;
	}

	Cart(ArrayList<Product> productList) {
		this.productList = productList;
		this.price = sumProducts(productList);
	}
	
	public void addProduct(Product product){
	
	}
	
	public void deleteProduct(int productId) {
			
	}
	
	public void deleteCart() {
		
	}
	
	public void checkout() {
		
	}
	
	
	

}
