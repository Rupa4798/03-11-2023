package com.shopping.entity;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//Indicates that this class is a JPA entity and will be mapped to a database table.
@Entity
//Specifies the table name to which this entity is mapped.
@Table(name="customer")
public class Customer {
// Marks the field as the primary key in the database table.
@Id
//Specifies the strategy for generating the primary key values automatically.
@GeneratedValue(strategy=GenerationType.AUTO)

	private Long cId;
	@NotNull(message = "Name is mandatory")
	private String cName;
	@NotBlank(message = "Address is required")
	@Size(max = 255, message = "Address must be at most 255 characters")
	private String cAddress;
	@NotBlank(message = "Contact is required")
    @Pattern(regexp = "\\d{10}", message = "Contact must be a 10-digit number")
	private Long cContact;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id") // Assuming the foreign key column name in the Product table
    private List<Product> products;
	
	
	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", cName=" + cName + ", cAddress=" + cAddress + ", cContact=" + cContact + "]";
	}
	public Long getcId() {
		return cId;
	}
	public void setcId(Long cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcAddress() {
		return cAddress;
	}
	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}
	public Long getcContact() {
		return cContact;
	}
	public void setcContact(Long cContact) {
		this.cContact = cContact;
	}
	public Customer() {
		
	}
	public Customer(Long cId, String cName, String cAddress, Long cContact) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cAddress = cAddress;
		this.cContact = cContact;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	

}
