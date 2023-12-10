package com.shopping.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
@Entity//Specifies that the class is an entity. This annotation is applied to the entity class
public class CartItem {

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    private Long pId;
	    private Long cId;
	    
	    @NotNull(message="Quantity cannot be null")//The annotated element must not be null
	    private int quantity;
	    private Long oId;
	    
	    @OneToMany(mappedBy = "cartItem", cascade = CascadeType.ALL)
	    private List<Product> products;
	    
	    // Default Constructor
	    @OneToOne(mappedBy = "cartItem", cascade = CascadeType.ALL)
	    @JoinColumn(name = "order_id", referencedColumnName = "oId")
	    private Order order;
	    
	    
	    
	    public CartItem() {
	    	
	    }
	    // Parameterized Constructor 
	    
		public CartItem(Long id, Long pId, Long cId, int quantity, Long oId) {
			this.id = id;
			this.pId = pId;
			this.cId = cId;
			this.quantity = quantity;
			this.oId = oId;
		}
		// getters and setters 
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getpId() {
			return pId;
		}
		public void setpId(Long pId) {
			this.pId = pId;
		}
		public Long getcId() {
			return cId;
		}
		public void setcId(Long cId) {
			this.cId = cId;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public Long getoId() {
			return oId;
		}
		public void setoId(Long oId) {
			this.oId = oId;
		}
		// to String is to display values
		@Override
		public String toString() {
			return "Cart [id=" + id + ", pId=" + pId + ", cId=" + cId + ", quantity=" + quantity + ", oId=" + oId + "]";
		}
	    

}