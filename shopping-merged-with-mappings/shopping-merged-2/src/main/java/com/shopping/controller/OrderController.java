package com.shopping.controller;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entity.Order;
import com.shopping.exception.OrderNotFoundException;
import com.shopping.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	private final OrderService orderService;
	
	private final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    public OrderController(OrderService orderService) {
    	
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
    	logger.info("Created");
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
    	
    	logger.info("updated");
        try {
            Order updatedOrder = orderService.updateOrder(id, order);
            return ResponseEntity.ok(updatedOrder);
        } catch (OrderNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        
    }
    
  
    
    
  
    
    
    
    
    
    
    
    
    
    @GetMapping("/{id}")
	public Optional<Order> getOrder(@PathVariable Long id) throws OrderNotFoundException{
    	
    	logger.info("Found");
		Optional<Order> optionalOrder =orderService.getOrder(id);
		
		optionalOrder.orElseThrow(()-> new OrderNotFoundException("Order not found "+id));
		return optionalOrder;
	}
   
   
    
    

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
    	logger.info("Printed");
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    
	
}

