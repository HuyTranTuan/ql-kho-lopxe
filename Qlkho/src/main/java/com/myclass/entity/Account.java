package com.myclass.entity;

import java.util.Date;

import javax.persistence.*;

@Entity(name = "accounts")
public class Account {

	@Id
	private String id;
	private String email;
	private String fullname;
	private String password;
	private String address;
	private String phone;

	@Column(name = "active_flag")
	private boolean activeFlag;

	@Column(name = "role_id")
	private int roleId;

	@Column(name = "create_date")
	@Temporal(TemporalType.DATE)
	private Date create;

	@Column(name = "update_date")
	@Temporal(TemporalType.DATE)
	private Date update;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id",insertable = false,updatable = false)
	private Role role;
	
	
	public Account() {}


	public Account(String id, String email, String fullname, String password, String address, String phone,
			boolean activeFlag, int roleId, Date create, Date update, Role role) {
		super();
		this.id = id;
		this.email = email;
		this.fullname = fullname;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.activeFlag = activeFlag;
		this.roleId = roleId;
		this.create = create;
		this.update = update;
		this.role = role;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public boolean isActiveFlag() {
		return activeFlag;
	}


	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
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


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}
	

}
