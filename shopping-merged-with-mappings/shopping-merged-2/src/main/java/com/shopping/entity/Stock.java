package com.shopping.entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;



@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pId;
    @Positive(message="quantity must be positive")
    private int sQuantity;
    @NotNull
    private String sLocation;
    @NotNull
    private String sSupplier;
	public Stock(Long pId, int sQuantity, String sLocation, String sSupplier) {
		
		this.sQuantity = sQuantity;
		this.sLocation = sLocation;
		this.sSupplier = sSupplier;
	}
	
	@OneToOne
    @JoinColumn(name = "pId")
    private Product product;
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getpId() {
		return pId;
	}
	public void setpId(Long pId) {
		this.pId = pId;
	}
	public int getsQuantity() {
		return sQuantity;
	}
	public void setsQuantity(int sQuantity) {
		this.sQuantity = sQuantity;
	}
	public String getsLocation() {
		return sLocation;
	}
	public void setsLocation(String sLocation) {
		this.sLocation = sLocation;
	}
	public String getsSupplier() {
		return sSupplier;
	}
	public void setsSupplier(String sSupplier) {
		this.sSupplier = sSupplier;
	}
	@Override
	public String toString() {
		return "Stock [pId=" + pId + ", sQuantity=" + sQuantity + ", sLocation=" + sLocation + ", sSupplier="
				+ sSupplier + "]";
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	

//	public Stock getStock() {
//        return stock;
//    }
//
//    public void setStock(Stock stock) {
//        this.stock = stock;
//        if (stock != null) {
//            stock.setProduct(this);
//        }
//    }

    
}
