package com.husen.jwt.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity

@Table(name = "warehouse_detail")
public class WarehouseDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "w_id")
	private int wid;
	@Column
	private String wname;
	@Column
	private String location;

	@ManyToOne
	@JoinColumn(name = "fk_p_id")
	private ProductDetails product;

	public WarehouseDetails() {
	}

	public WarehouseDetails(int wid, String wname, String location, ProductDetails product) {
		super();
		this.wid = wid;
		this.wname = wname;
		this.location = location;
		this.product = product;
	}

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@JsonBackReference
	public ProductDetails getProduct() {
		return product;
	}

	public void setProduct(ProductDetails product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Warehouse [wid=" + wid + ", wname=" + wname + ", location=" + location + ", product=" + product + "]";
	}

}
