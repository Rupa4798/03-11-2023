package com.shopping.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eId;
	
	@Column
	@NotNull(message = "Employee Name cannot be null")
	private String eName;
	
	@Column
	@NotNull(message = "Employee salary cannot be null")
	@Positive(message = "Employee salary must be positive")
	private float eSal;
	
	@NotNull(message = "Employee position cannot be null")
	@Column
	private String ePosition;
	
	//constructor

	public Employee() {
	}
	
	//constructor with parameters
	public Employee(Long eId, String eName, float eSal, String ePosition) {
		this.eId = eId;
		this.eName = eName;
		this.eSal = eSal;
		this.ePosition = ePosition;
	}
	
	//getters and setters

	public Long geteId() {
		return eId;
	}

	public void seteId(Long eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public float geteSal() {
		return eSal;
	}

	public void seteSal(float eSal) {
		this.eSal = eSal;
	}

	public String getePosition() {
		return ePosition;
	}

	public void setePosition(String ePosition) {
		this.ePosition = ePosition;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", eSal=" + eSal + ", ePosition=" + ePosition + "]";
	}
	
	@ManyToMany
    private Set<Order> orders = new HashSet<>();

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

}
