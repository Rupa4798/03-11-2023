package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entity.CartItem;

// it is an interface that Extends jpaRepository used for managing database
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
