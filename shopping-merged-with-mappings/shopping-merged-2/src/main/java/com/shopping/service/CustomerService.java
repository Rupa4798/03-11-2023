package com.shopping.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.entity.Customer;
import com.shopping.exception.CustomerNotFoundException;
import com.shopping.repository.CustomerRepository;

import java.util.List;
	import java.util.Optional;

	@Service
	public class CustomerService {

	    private final CustomerRepository customerRepository;

	    @Autowired
	    //it automatically injects the dependencies 
	    public CustomerService(CustomerRepository customerRepository) {
	        this.customerRepository = customerRepository;
	    }

	    public List<Customer> listCustomers() {
	        return customerRepository.findAll();
	    }
	    public Customer getCustomerById1(Long id) {
	        return customerRepository.findById(id)
	                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));
	    }
       //Optional is used to avoid the null pointer exceptions
	    public Optional<Customer> getCustomerById(Long id) {
	        return customerRepository.findById(id);
	    }
	    

	    public Customer createCustomer(Customer customer) {
	        return customerRepository.save(customer);
	    }

	    public void deleteCustomerById(Long id) {
	        customerRepository.deleteById(id);
	    }

	    public Customer editCustomer(Long id,Customer customer) {

	    	if(customerRepository.existsById(id)) {
	    	customer .setcId(id);
	        return customerRepository.save(customer);
	    	}
	    	else {
			return null;}
	    }

	}


