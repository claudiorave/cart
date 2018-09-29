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

	private final CartRepository repository;

	CartController(CartRepository repository) {
		this.repository = repository;
	}

	// Aggregate root

	@GetMapping("/products")
	List<Product> all() {
		return repository.findAll();
	}

	@PostMapping("/products")
	Product newEmployee(@RequestBody Product newEmployee) {
		return repository.save(newEmployee);
	}

	// Single item

	@GetMapping("/products/{id}")
	Optional<Product> one(@PathVariable Long id) {

		return repository.findById(id);
	}

	@PutMapping("/employees/{id}")
	Product replaceEmployee(@RequestBody Product newEmployee, @PathVariable Long id) {

		return repository.findById(id)
			.map(product -> {
				product.setTitle(newEmployee.getTitle());
				product.setPrice(newEmployee.getPrice());
				return repository.save(product);
			})
			.orElseGet(() -> {
				newEmployee.setId(id);
				return repository.save(newEmployee);
			});
	}

	@DeleteMapping("/employees/{id}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}
}