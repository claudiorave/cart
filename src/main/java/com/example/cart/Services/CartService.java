package com.example.cart.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.example.cart.Repositories.CartRepository;
import com.example.cart.Resources.Cart;
import com.example.cart.Resources.Product;
import com.example.cart.Resources.ProductPurchase;
import com.example.cart.Resources.ProductPurchaseDTO;

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

	public Cart addNewCart(ArrayList<ProductPurchase> productPurchase) {
		
		Cart cart = new Cart(productPurchase);
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

	public boolean addProduct(Long cartId, Long productId, int quantity) {
		Optional<Cart> cart = repository.findById(cartId);
		Product product = itemsService.getItem(productId);
		if (product != null) {
			cart.get().addProduct(product, quantity);
			return true;
		} else {
			return false;
		}

	}

	public boolean deleteProduct(Long cartId, Long productId, int quantity) {
		Optional<Cart> cart = repository.findById(cartId);
		Product product = itemsService.getItem(productId);
		if (product != null) {
			cart.get().deleteProduct(product, quantity);
			return true;
		} else {
			return false;
		}

	}

}
