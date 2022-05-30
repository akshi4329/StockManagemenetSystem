package com.husen.jwt.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "product_details")
public class ProductDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_id")
	private int pid;
	@Column
	private String pname;
	@Column
	private int price;
	@Column
	private int quantity;
	@Column
	private Date date;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<WarehouseDetails> warehouse;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<CategoryDetails> category;

public ProductDetails() {
}

public ProductDetails(int pid, String pname, int price, int quantity, Date date, Set<WarehouseDetails> warehouse, Set<CategoryDetails> category) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.price = price;
	this.quantity = quantity;
	this.date = date;
	this.warehouse = warehouse;
	this.category = category;
}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@JsonManagedReference
	public Set<WarehouseDetails> getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Set<WarehouseDetails> warehouse) {
		this.warehouse = warehouse;
	}

	@JsonManagedReference
	public Set<CategoryDetails> getCategory() {
		return category;
	}

	public void setCategory(Set<CategoryDetails> category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", quantity=" + quantity + ", date="
				+ date + ", warehouse=" + warehouse + ", category=" + category + "]";
	}

}
