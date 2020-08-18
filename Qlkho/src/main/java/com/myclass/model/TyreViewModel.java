package com.myclass.model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class TyreViewModel {

	private String id;
	
	@NotEmpty(message = "Tên lốp xe không được bỏ trống!")
	private String name;
	
	@NotEmpty(message = "Tên thương hiệu không được bỏ trống!")
	private String brand;
	private int quantity;
	private String type;
	private int price;
	private Date create;
	private Date update;
	
	public TyreViewModel() {}

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

	public TyreViewModel(String id, String name, String brand, int quantity, String type, int price, Date create,
			Date update) {
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
}
