package com.shopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.entity.CartItem;
import com.shopping.repository.CartItemRepository;

@Service//  Identify and register a class as a service component
	public class CartItemService {
	    @Autowired //Instructs Spring to automatically inject the necessary repo
	    private CartItemRepository cartItemRepository;

	    public List<CartItem> getAllCartItems() {
	        return cartItemRepository.findAll();
	    }

	    public CartItem getCartItemById(Long id) {
	        return cartItemRepository.findById(id).orElse(null);
	    }

	    public CartItem saveCartItem(CartItem cartItem) {
	        return cartItemRepository.save(cartItem);
	    }
	    public CartItem updateCartItem(Long id, CartItem updatedCartItem) {
	        Optional<CartItem> existingCartItemOptional = cartItemRepository.findById(id);
	        if (existingCartItemOptional.isPresent()) {
	            CartItem existingCartItem = existingCartItemOptional.get();
	            existingCartItem.setoId(updatedCartItem.getoId());
	            existingCartItem.setpId(updatedCartItem.getpId());
	            existingCartItem.setcId(updatedCartItem.getcId());
	            existingCartItem.setQuantity(updatedCartItem.getQuantity());
	            return cartItemRepository.save(existingCartItem);
	        } else {
	            // Handle not found case
	            return null;
	        }
	        }

	    public void deleteCartItem(Long id) {
	        cartItemRepository.deleteById(id);
	    }
}

