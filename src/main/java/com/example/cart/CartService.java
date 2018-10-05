package com.example.cart;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class CartService {
	private CartRepository repository;
	private ItemsService itemsService;

	public CartService(CartRepository repository, ItemsService itemsService) {
		this.repository = repository;
		this.itemsService = itemsService;
	}

	public Optional<Cart> getCart(Long Id) {
		return repository.findById(Id);
	}

	public void insertCart(Cart cart) {
		repository.save(cart);
	}

	public Cart addNewCart() {
		Cart cart = new Cart();
		return repository.save(cart);
	}

	public boolean deleteCart(Long Id) {
		if (repository.existsById(Id)) {
			repository.deleteById(Id);
			return true;
		} else {
			return false;
		}
	}

	public boolean addProduct(Long cartId, Long productId) {
		Optional<Cart> cart = repository.findById(cartId);
		Product product = itemsService.getItem(productId);
		if (product != null) {
			cart.get().addProduct(product);
			return true;
		} else {
			return false;
		}

	}

	public boolean deleteProduct(Long cartId, Long productId) {
		Optional<Cart> cart = repository.findById(cartId);
		Product product = itemsService.getItem(productId);
		if (product != null) {
			cart.get().addProduct(product);
			return true;
		} else {
			return false;
		}

	}

}
