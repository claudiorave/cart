package com.example.cart;

import org.springframework.data.jpa.repository.JpaRepository;

interface CartRepository extends JpaRepository<Product, Long> {

}