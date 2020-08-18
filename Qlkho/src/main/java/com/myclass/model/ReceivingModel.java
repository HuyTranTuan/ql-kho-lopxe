package com.myclass.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class ReceivingModel {

	private String id;
	
	@NotNull(message = "Số lượng chưa được chọn!")
	private int quantity;
	
	private String note;
	private Date create;
	private boolean activeFlag;
	
	@NotNull(message = "Khách hànhg chưa được chọn!")
	private String customer;
	
	@NotNull(message = "Lốp xe chưa được chọn!")
	private String tyre;
	
	public ReceivingModel() {}

	public ReceivingModel(String id, int quantity, String note, Date create, boolean activeFlag, String customer,
			String tyre) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.note = note;
		this.create = create;
		this.activeFlag = activeFlag;
		this.customer = customer;
		this.tyre = tyre;
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
}
