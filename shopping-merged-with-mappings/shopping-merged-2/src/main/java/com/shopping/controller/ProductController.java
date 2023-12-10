package com.shopping.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entity.Product;
import com.shopping.exception.ProductNotFoundException;
import com.shopping.service.ProductService;

//Define this class as a controller that handles HTTP requests related to products
@RestController
//Map all requests starting with "/products" to this controller
@RequestMapping("/products")
public class ProductController {

	// Initialize a logger for logging messages
	Logger logger = LogManager.getLogger(LogManager.class);

	// Inject ProductService dependency for handling business logic related to
	// products
	@Autowired
	private ProductService productService;

	// Handle HTTP POST requests to create a new product
	@PostMapping
	public Product createProduct(@RequestBody Product product) {

		// Log information about the creation of a product
		logger.info("Product Created");
		// Delegate the creation logic to the ProductService and return the result
		return productService.createProduct(product);
	}

	// Handle HTTP GET requests to retrieve a list of all products
	@GetMapping
	public List<Product> listProducts() {
		// Log information about listing products
		logger.info("List Created");
		// Delegate the listing logic to the ProductService and return the result
		return productService.listProducts();
	}

	// Uncomment the following lines if needed for edit/update functionality
	// Handle HTTP PUT requests to edit/update an existing product
	@PutMapping("/{productId}")
	public Product editProduct(@PathVariable Long productId, @RequestBody Product product) {
		// Delegate the edit/update logic to the ProductService and return the result
		return productService.updateProduct(productId, product);
	}

	// Handle HTTP GET requests to retrieve details of a specific product by ID
	@GetMapping("/{productId}")
	public Product viewProduct(@PathVariable Long productId) {
		// Log information about viewing a product
		logger.info("View Product");
		// Delegate the view logic to the ProductService and return the result
		return productService.viewProduct(productId);
	}

	// Handle HTTP DELETE requests to delete a specific product by ID
	@DeleteMapping("/{productId}")
	public void deleteProduct(@PathVariable Long productId) {
		// Log information about the deletion of a product
		logger.info("Product Deleted");
		// Delegate the deletion logic to the ProductService
		productService.deleteProduct(productId);
	}

	// Handle HTTP PUT requests to update an existing product by ID
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable(value = "id") Long id, @Validated @RequestBody Product newProduct) {
		// Log information about updating a product
		logger.info("Product Updated");
		// Delegate the update logic to the ProductService and return the result
		return productService.updateProduct(id, newProduct);
	}

//global exception handler ProductNotFoundException
//This annotation is used to define a method to handle exceptions of a specific type.
	@ExceptionHandler(ProductNotFoundException.class)
//This method handles the exception of type ProductNotFoundException.
	public String handleCustomerNotFoundException(ProductNotFoundException ex) {
		// The method returns the error message associated with the exception.
		return ex.getMessage();
	}
}
