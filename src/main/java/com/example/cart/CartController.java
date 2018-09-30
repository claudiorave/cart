package com.example.cart;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CartController {

	private final CartRepository repositoryC;
	private final ProductRepository repositoryP;

	CartController(CartRepository repositoryC, ProductRepository repositoryP) {
		this.repositoryC = repositoryC;
		this.repositoryP = repositoryP;
	}

	// Aggregate root

	@GetMapping("/products")
	List<Product> all() {
		return repositoryP.findAll();
	}

	@PostMapping("/cart/products")
	Product newEmployee(@RequestBody Product newProduct) {
		return repositoryP.save(newProduct);
	}

	// Single item

	@GetMapping("/products/{id}")
	Optional<Product> one(@PathVariable Long id) {

		return repositoryP.findById(id);
	}



	@DeleteMapping("/cart/{id}")
	void deleteCart(@PathVariable Long id) {
	
	}
}