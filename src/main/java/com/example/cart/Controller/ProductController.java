package com.example.cart.Controller;

import org.springframework.web.bind.annotation.*;

import com.example.cart.Resources.Product;
import com.example.cart.Services.ItemsService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class ProductController {

	private ItemsService service;

	ProductController(ItemsService service) {
		this.service = service;
	}

	// Retrieves all products

	@GetMapping("/products")
	ResponseEntity getAllProducts() {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getAllItems());
	}

	// Retrieves single item

	@GetMapping("/products/{id}")
	ResponseEntity getProduct(@PathVariable Long id) {
		Product product = service.getItem(id);
		if (product != null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(product);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

}
