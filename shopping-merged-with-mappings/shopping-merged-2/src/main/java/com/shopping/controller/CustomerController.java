package com.shopping.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.shopping.entity.Customer;
import com.shopping.exception.CustomerNotFoundException;
import com.shopping.service.CustomerService;

@RestController
//Maps the controller to requests with the "/customers" base URL.
@RequestMapping("/customers")
public class CustomerController {
	Logger logger = LogManager.getLogger(LogManager.class);

	private final CustomerService customerService;

	@Autowired
	// Injects an instance of CustomerService into the controller using constructor
	// injection.
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;

	}

	// retrieve all customers
	@GetMapping
	public List<Customer> listCustomers() {
		logger.info("list created");
		return customerService.listCustomers();
	}

	// retrieve a specific customer id
	@GetMapping("/{id}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable Long id) {
		Optional<Customer> customer = customerService.getCustomerById(id);
		return customer.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
    //create a new customer
	@PostMapping("/create")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		logger.info("customer created");
		Customer createdCustomer = customerService.createCustomer(customer);
		return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
	}

	// delete the customer by id
	/*@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
		logger.info("customer deleted");
		customerService.deleteCustomerById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}*/

	// update the customer by id
	@PutMapping("/edit/{id}")
	public ResponseEntity<Customer> editCustomer(@PathVariable Long id, @RequestBody Customer customer) {
		logger.info("customer updated");
		Customer updatedCustomer = customerService.editCustomer(id, customer);
		return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
	}

	// Example of getting product details by product name using query parameter
	@GetMapping("/getProductByProduct")
	public ResponseEntity<String> getProductByProduct(@RequestParam String productName) {
		String productDetails = "Product: " + productName + " details...";
		return new ResponseEntity<>(productDetails, HttpStatus.OK);
	}

	// global exception handler CustomerNotFoundException
	@ExceptionHandler(CustomerNotFoundException.class)
	public String handleCustomerNotFoundException(CustomerNotFoundException ex) {
		return ex.getMessage();
	}
}
