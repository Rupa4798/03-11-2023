package com.shopping.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entity.CartItem;
import com.shopping.exception.CartItemNotFoundException;
import com.shopping.service.CartItemService;

@RestController //Controller for RESTapi to return JSON
@RequestMapping("/cart")// Handles any HTTP method
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;
    Logger logger = LogManager.getLogger(CartItemController.class);
    @GetMapping // Specifically for GET request
    public List<CartItem> getAllCartItems() {
    	logger.info(" Items in Cart ");
        return cartItemService.getAllCartItems();
    }
//    @GetMapping("/{id}")
//    public CartItem getCartItemById(@PathVariable Long id) {
//    	// PathVariable extract the value of a variable and assign to method
//    	
//    	logger.info("Items in cart by Id");
//        return cartItemService.getCartItemById(id);
//    }
    
    @GetMapping("/{id}")
	public Optional<CartItem> getCartItemById(@PathVariable Long id) throws CartItemNotFoundException {
		logger.info("get employee details by ID");
		Optional<CartItem> optionalCartItem =Optional.ofNullable(cartItemService.getCartItemById(id));
		optionalCartItem.orElseThrow(()-> new CartItemNotFoundException("CartItems not found "+id));
		return optionalCartItem;
	}
    
    
    @PostMapping
    public CartItem saveCartItem(@RequestBody CartItem cartItem) {
    	// RequestBody body to transfer domain object to java object
    	logger.info("Items is saved");
        return cartItemService.saveCartItem(cartItem);
    }
    @PutMapping("/{id}")
    public CartItem updateCartItem(@PathVariable Long id, @RequestBody CartItem updatedCartItem) {
    	logger.info("Items is updated to Cart");
    	return cartItemService.updateCartItem(id, updatedCartItem);
    }
    @DeleteMapping("/{id}")
    public void deleteCartItem(@PathVariable Long id) {
    	logger.info("Items is removed from cart");
        cartItemService.deleteCartItem(id);
    }
}
