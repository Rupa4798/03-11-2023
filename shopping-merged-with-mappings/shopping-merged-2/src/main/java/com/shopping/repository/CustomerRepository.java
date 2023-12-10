package com.shopping.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.entity.Customer;
//used to indicate that this interface is a Spring-managed repository component.
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
 
}
	