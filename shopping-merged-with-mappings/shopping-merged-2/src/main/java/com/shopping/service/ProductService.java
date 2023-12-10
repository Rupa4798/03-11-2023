package com.shopping.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

import com.shopping.entity.Product;
import com.shopping.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
 
//Define this class as a service, responsible for handling business logic related to products
@Service
public class ProductService {

 // Inject ProductRepository dependency for database operations
 @Autowired
 private ProductRepository productRepository;

 // Service method to create a new product
 public Product createProduct(Product product) {
     // Save the product using the injected ProductRepository and return the result
     return productRepository.save(product);
 }

 // Service method to retrieve a list of all products
 public List<Product> listProducts() {
     // Retrieve all products using the injected ProductRepository and return the result
     return productRepository.findAll();
 }

 /* Uncomment the following lines if needed for update functionality
 // Service method to update an existing product
 public Product updateProduct(Long productId, Product updatedProduct) {
     // Find the existing product by ID using the ProductRepository
     Optional<Product> existingProduct = productRepository.findById(productId);

     // Check if the product with the given ID exists
     if (existingProduct.isPresent()) {
         // If exists, update the fields based on your requirements
         Product product = existingProduct.get();
         product.setpName(updatedProduct.getpName());
         product.setpDesc(updatedProduct.getpDesc());
         product.setpCategory(updatedProduct.getpCategory());
         product.setpPrice(updatedProduct.getpPrice());

         // Save the updated product and return the result
         return productRepository.save(product);
     } else {
         // If the product with the given ID doesn't exist, throw an exception
         throw new RuntimeException("Product not found with id: " + productId);
     }
 }
 */

 // Service method to retrieve details of a specific product by ID
 public Product viewProduct(Long productId) {
     // Find the product by ID using the ProductRepository, or throw an exception if not found
     return productRepository.findById(productId)
             .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
 }

 // Service method to delete a specific product by ID
 public void deleteProduct(Long productId) {
     // Delete the product by ID using the ProductRepository
     productRepository.deleteById(productId);
 }

 // Service method to update an existing product by ID
 public Product updateProduct(Long id, Product product) {
     // Implement update logic here
     // Check if the product with the given ID exists before updating
     if (productRepository.existsById(id)) {
         // Set the ID of the incoming product to match the existing product
         product.setpId(id);
         // Save the updated product and return the result
         return productRepository.save(product);
     }
     // Handle the case where the product with the given ID doesn't exist
     return null;
 }
}



