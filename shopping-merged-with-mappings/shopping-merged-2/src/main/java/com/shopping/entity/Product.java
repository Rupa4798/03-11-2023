package com.shopping.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

//Define this class as an entity, representing a database table named "Product"
@Entity
@Table(name = "Product")
public class Product {

	public Product() {

	}

// Constructor to initialize the product with specified attributes
	public Product(Long pId, String pName, String pDesc, Double pPrice, String pCategory) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pDesc = pDesc;
		this.pPrice = pPrice;
		this.pCategory = pCategory;
	}

	// Primary key identifier for the product, automatically generated
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pId;

	// Validation annotation: The product name cannot be null
	@NotNull(message = "Name is Mandatory")
	private String pName;

	// Description of the product
	private String pDesc;

	private Double pPrice;

	// Validation annotation: The product category cannot be null
	@NotNull(message = "Category is required")
	private String pCategory;
	
	
	 @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	 private Stock stock;
	 
	 
	 @ManyToOne
	    @JoinColumn(name = "cart_item_id") // Assuming the foreign key column name in the Product table
	    private CartItem cartItem;
	// Getter method for retrieving the product ID
	public Long getpId() {
		return pId;
	}

	// Setter method for setting the product ID
	public void setpId(Long pId) {
		this.pId = pId;
	}

	// Getter method for retrieving the product name
	public String getpName() {
		return pName;
	}

	// Setter method for setting the product name
	public void setpName(String pName) {
		this.pName = pName;
	}

	// Getter method for retrieving the product description
	public String getpDesc() {
		return pDesc;
	}

	// Setter method for setting the product description
	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}

	// Getter method for retrieving the product price
	public Double getpPrice() {
		return pPrice;
	}

	// Setter method for setting the product price
	public void setpPrice(Double pPrice) {
		this.pPrice = pPrice;
	}

	// Getter method for retrieving the product category
	public String getpCategory() {
		return pCategory;
	}

	// Setter method for setting the product category
	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}

	// Override toString method for displaying the product details as a string
	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pName=" + pName + ", pDesc=" + pDesc + ", pPrice=" + pPrice + ", pCategory="
				+ pCategory + "]";
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
//		if (stock != null) {
//            stock.setProduct(this);
//        }
	}
	
	
}
