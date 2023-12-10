package com.shopping.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
    public Order() {
		super();
	}
	public Order(Long oId, String oName, String oDate) {
		super();
		this.oId = oId;
		this.oName = oName;
		this.oDate = oDate;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long oId;
    private String oName;
    private String oDate;
    
    @OneToOne
    private CartItem cartItem;

    
	public Long getoId() {
		return oId;
	}
	public void setoId(Long oId) {
		this.oId = oId;
	}
	public String getoName() {
		return oName;
	}
	public void setoName(String oName) {
		this.oName = oName;
	}
	public String getoDate() {
		return oDate;
	}
	public void setoDate(String oDate) {
		this.oDate = oDate;
	}
	@Override
	public String toString() {
		return "Order [oId=" + oId + ", oName=" + oName + ", oDate=" + oDate + "]";
	}
	
	@ManyToMany(mappedBy = "orders")
    private Set<Employee> employees = new HashSet<>();

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employee.getOrders().add(this);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        employee.getOrders().remove(this);
    }
    
    
    
    
    
    
    
}