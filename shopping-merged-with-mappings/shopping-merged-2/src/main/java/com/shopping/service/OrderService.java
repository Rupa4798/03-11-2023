package com.shopping.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.entity.Order;
import com.shopping.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id,Order order) {
        // Implement update logic
        // You might want to check if the order with the given ID exists before updating
    	  	
    	
    	if (orderRepository.existsById(id)) {
            order.setoId(id);
            return orderRepository.save(order);
        }
        return null; // Handle the case where the employee with the given id doesn't exist
   }
    	
    	
    public Optional<Order> getOrder(Long id) {

		return orderRepository.findById(id);
		
	}	
    	
 

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}