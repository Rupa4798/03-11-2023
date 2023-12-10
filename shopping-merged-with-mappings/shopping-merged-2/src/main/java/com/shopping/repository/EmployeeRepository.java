package com.shopping.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
 // Additional query methods can be added here if needed
}

