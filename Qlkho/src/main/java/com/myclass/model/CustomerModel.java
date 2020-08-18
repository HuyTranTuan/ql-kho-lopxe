package com.myclass.model;

import javax.validation.constraints.NotEmpty;

public class CustomerModel {

	private int id;
	
	@NotEmpty(message = "Tên khách hàng không được bỏ trống!")
	private String name;
	private String phone;
	
	@NotEmpty(message = "Địa chỉ không được bỏ trống!")
	private String address;
	private boolean activeFlag;
	
	public CustomerModel() {}

	public CustomerModel(int id, String name, String phone, String address, boolean activeFlag) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.activeFlag = activeFlag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	
}
