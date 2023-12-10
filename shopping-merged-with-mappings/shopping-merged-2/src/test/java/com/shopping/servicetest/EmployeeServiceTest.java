package com.shopping.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.shopping.entity.Employee;
import com.shopping.exception.EmployeeNotFoundException;
import com.shopping.repository.EmployeeRepository;
import com.shopping.service.EmployeeService;

@SpringBootTest
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void testGetAllEmployees() {
        // Arrange
        Employee employee1 = new Employee(1L, "Aravind", 50000.0f, "admin");
        Employee employee2 = new Employee(2L, "Aravind Reddy", 60000.0f, "Manager");
        List<Employee> employees = Arrays.asList(employee1, employee2);

        when(employeeRepository.findAll()).thenReturn(employees);

        // Act
        List<Employee> result = employeeService.getAllEmployees();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Aravind", result.get(0).geteName());
        assertEquals("Aravind Reddy", result.get(1).geteName());
    }

    @Test
    public void testGetEmployeeById() {
        // Arrange
        Employee employee = new Employee(1L, "Aravind", 50000.0f, "admin");
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        // Act
        Optional<Employee> result = employeeService.getEmployeeById(1L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals("Aravind", result.get().geteName());
    }

    @Test
    public void testGetEmployeeById_NotFound() {
        // Arrange
        when(employeeRepository.findById(1L)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.getEmployeeById(1L));
    }

    @Test
    public void testSaveEmployee() {
        // Arrange
        Employee employee = new Employee(1L, "Aravind", 50000.0f, "admin");
        when(employeeRepository.save(employee)).thenReturn(employee);

        // Act
        Employee result = employeeService.saveEmployee(employee);

        // Assert
        assertEquals("Aravind", result.geteName());
    }

    @Test
    public void testDeleteEmployee() {
        // Arrange

        // Act
        employeeService.deleteEmployee(1L);

        // Assert
        verify(employeeRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testUpdateEmployee() {
        // Arrange
        Employee existingEmployee = new Employee(1L, "Aravind", 50000.0f, "admin");
        Employee newEmployeeData = new Employee(1L, "Aravind reddy", 60000.0f, "Manager");

        when(employeeRepository.existsById(1L)).thenReturn(true);
        when(employeeRepository.save(newEmployeeData)).thenReturn(newEmployeeData);

        // Act
        Employee result = employeeService.updateEmployee(1L, newEmployeeData);

        // Assert
        assertEquals("Aravind reddy", result.geteName());
        assertEquals(60000.0f, result.geteSal());
        assertEquals("Manager", result.getePosition());
    }

    @Test
    public void testUpdateEmployee_NotFound() {
        // Arrange
        Employee newEmployeeData = new Employee(1L, "Aravind reddy", 60000.0f, "Manager");

        when(employeeRepository.existsById(1L)).thenReturn(false);

        // Act and Assert
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.updateEmployee(1L, newEmployeeData));
    }
}
