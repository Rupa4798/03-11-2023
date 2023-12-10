package com.shopping.service;

//EmployeeService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.entity.Employee;
import com.shopping.exception.EmployeeNotFoundException;
import com.shopping.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> getEmployeeById(Long id) {
		return employeeRepository.findById(id);
	}

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

	public Employee updateEmployee(Long id, Employee newEmployee) {
		if (employeeRepository.existsById(id)) {
			newEmployee.seteId(id);
			return employeeRepository.save(newEmployee);
		}
		return null;
	 
	}
}
