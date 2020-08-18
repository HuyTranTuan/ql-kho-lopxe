package com.myclass.model;

import javax.validation.constraints.NotEmpty;

public class RoleViewModel {

	private int id;
	
	@NotEmpty(message = "Tên quyền không được bỏ trống!")
	private String name;
	
	@NotEmpty(message = "Mô tả không được bỏ trống!")
	private String description;
	
	public RoleViewModel() {}

	public RoleViewModel(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
