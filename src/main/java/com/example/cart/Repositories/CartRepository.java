package com.example.cart.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cart.Resources.*;

public interface CartRepository extends JpaRepository<Cart, Long> {

}