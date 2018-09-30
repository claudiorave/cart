package com.example.cart;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.*;




@RestController
class CartController {

	private final CartRepository repositoryC;
	private final ProductRepository repositoryP;

	CartController(CartRepository repositoryC, ProductRepository repositoryP) {
		this.repositoryC = repositoryC;
		this.repositoryP = repositoryP;
	}

	// All 

	@GetMapping("/products")
	List<Product> allProducts() {
		return repositoryP.findAll();
	}

	@PostMapping("/cart/products")
	Product newProduct(@RequestBody Product newProduct) {
		return repositoryP.save(newProduct);
	}

	// Single item
	
	@GetMapping("/products/{id}")
	ResponseEntity getProduct(@PathVariable Long id) {
		//Not working as expected, findById returns null if Id is wrong. No exception thrown. 
		try {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(repositoryP.findById(id)); 
		}
		catch(NoResultException E) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}



	@DeleteMapping("/cart/{id}")
	void deleteCart(@PathVariable Long id) {
	}
}