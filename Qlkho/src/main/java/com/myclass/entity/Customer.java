package com.myclass.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "customers")
public class Customer {

	@Id
	private int id;
	
	private String name;
	private String phone;
	private String address;
	
	@Column(name = "active_flag")
	private boolean activeFlag;
	
	public Customer() {}

	public Customer(int id, String name, String phone, String address, boolean activeFlag) {
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
