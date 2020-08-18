package com.myclass.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "delivery")
public class Delivery {

	@Id
	private String id;
	
	private int quantity;
	private String note;
	
	@Column(name = "customer_id")
	private String customer;
	
	@Column(name = "tyre_id")
	private String tyre;
	
	@Column(name = "create_date")
	@Temporal(TemporalType.DATE)
	private Date create;
	
	@Column(name = "active_flag")
	private boolean activeFlag;
	
	public Delivery() {}

	public Delivery(String id, int quantity, String note, String customer, String tyre, Date create,
			boolean activeFlag) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.note = note;
		this.customer = customer;
		this.tyre = tyre;
		this.create = create;
		this.activeFlag = activeFlag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getTyre() {
		return tyre;
	}

	public void setTyre(String tyre) {
		this.tyre = tyre;
	}

	public Date getCreate() {
		return create;
	}

	public void setCreate(Date create) {
		this.create = create;
	}

	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
}
