package com.example.cart;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
class CartController {

	private final CartService service;

	CartController(CartService service) {
		this.service = service;

	}

	@PostMapping("/cart/{cartId}/products/{productId}")
	ResponseEntity addNewProduct(@PathVariable Long cartId, @PathVariable Long productId) {
		if (service.addProduct(cartId, productId)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	};

	@DeleteMapping("/cart/{cartId}/products/{productId}")
	ResponseEntity deleteProduct(@PathVariable Long cartId, @PathVariable Long productId) {
		if (service.deleteProduct(cartId, productId)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	};

	// Not yet implemented. Create new Cart.
	@PostMapping("/cart")
	ResponseEntity createNewCart() {
		if (service.addNewCart() != null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.addNewCart());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	};

	// Deletes Cart
	@DeleteMapping("/cart/{id}")
	ResponseEntity deleteCart(@PathVariable Long id) {
		if (service.deleteCart(id)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
}