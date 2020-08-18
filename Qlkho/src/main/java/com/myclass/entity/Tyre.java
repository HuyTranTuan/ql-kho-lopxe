package com.myclass.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "tyres")
public class Tyre {
	@Id
	private String id;
	
	private String name;
	private String brand;
	private int quantity;
	private String type;
	private int price;
	
	@Column(name = "create_date")
	@Temporal(TemporalType.DATE)
	private Date create;

	@Column(name = "update_date")
	@Temporal(TemporalType.DATE)
	private Date update;
	
	public Tyre() {}

	public Tyre(String id, String name, String brand, int quantity, String type, int price, Date create, Date update) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.quantity = quantity;
		this.type = type;
		this.price = price;
		this.create = create;
		this.update = update;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getCreate() {
		return create;
	}

	public void setCreate(Date create) {
		this.create = create;
	}

	public Date getUpdate() {
		return update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}
}
