package com.example.cart.Controller;

import org.springframework.web.bind.annotation.*;

import com.example.cart.Resources.ProductPurchase;
import com.example.cart.Resources.ProductPurchaseDTO;
import com.example.cart.Services.CartService;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
class CartController {

	private final CartService service;

	CartController(CartService service) {
		this.service = service;

	}

	@PostMapping("/carts/{cartId}/products/{productId}/{quantity}")
	ResponseEntity addNewProduct(@PathVariable Long cartId, @PathVariable Long productId, @PathVariable int quantity) {
		if (service.addProduct(cartId, productId, quantity)) {
			return ResponseEntity.status(HttpStatus.CREATED).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	};

	@DeleteMapping("/carts/{cartId}/products/{productId}/{quantity}")
	ResponseEntity deleteProduct(@PathVariable Long cartId, @PathVariable Long productId, @PathVariable int quantity) {
		if (service.deleteProduct(cartId, productId, quantity)) {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	};

	// Not yet implemented. Create new Cart.
	@PostMapping("/carts")
	ResponseEntity createNewCart(@RequestBody ArrayList<ProductPurchase> purchase) {
		if (service.addNewCart(purchase) != null) {
			return ResponseEntity.status(HttpStatus.OK).body(service.addNewCart(purchase));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	};

	// Deletes Cart
	@DeleteMapping("/carts/{id}")
	ResponseEntity deleteCart(@PathVariable Long id) {
		if (service.deleteCart(id)) {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
}