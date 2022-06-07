package com.husen.jwt.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "product_details")
public class ProductDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_id")
	private int pid;
	
	@NotEmpty
	@Column(name = "p_name")
	private String pname;
	
	@NotEmpty
	@Column(name = "p_price")
	private int price;
	
	@NotEmpty
	@Column(name = "p_quantity")
	private int quantity;
	
	@NotEmpty
	@Column(name = "date")
	private String date;

	@ManyToOne()
    @JoinColumn(name = "fk_cid")
    private CategoryDetails category;

    @ManyToOne()
    @JoinColumn(name = "fk_wid")
    private WarehouseDetails warehouse;

public ProductDetails() {
}

public ProductDetails(int pid, String pname, int price, int quantity, String date, CategoryDetails category,
		WarehouseDetails warehouse) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.price = price;
	this.quantity = quantity;
	this.date = date;
	this.category = category;
	this.warehouse = warehouse;
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

	public String getString() {
		return date;
	}

	public void setString(String date) {
		this.date = date;
	}
	@JsonBackReference(value="category-product")
	public CategoryDetails getCategory() {
		return category;
	}

	public void setCategory(CategoryDetails category) {
		this.category = category;
	}
	@JsonBackReference
	public WarehouseDetails getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(WarehouseDetails warehouse) {
		this.warehouse = warehouse;
	}

	@Override
	public String toString() {
		return "ProductDetails [pid=" + pid + ", pname=" + pname + ", price=" + price + ", quantity=" + quantity + ", date="
			+ date + ", category=" + category + ", warehouse=" + warehouse + "]";
	}


}
