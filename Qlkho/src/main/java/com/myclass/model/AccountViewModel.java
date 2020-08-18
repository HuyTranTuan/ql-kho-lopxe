package com.myclass.model;

import java.util.Date;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

import com.myclass.entity.Role;

public class AccountViewModel {

	private String id;
	
	@NotEmpty(message = "Email không được bỏ trống!")
	@Email(message = "Email không đúng định dạng")
	private String email;
	
	@NotEmpty(message = "Họ tên không được bỏ trống!")
	@Length(min = 4, message = "Họ tên phải có ít nhất 4 kí tự!")
	private String fullname;
	
	@NotEmpty(message = "Mật khẩu không được bỏ trống!")
	@Length(min = 6, message = "Mật khẩu phải có ít nhất 6 kí tự!")
	private String password;
	
	private String address;
	private String phone;
	private boolean activeFlag;
	
	@NotNull(message = "Loại người dùng chưa được chọn!")
	private int roleId;
	private Date create;
	private Date update;
	private Role role;
	
	
	public AccountViewModel() {}


	public AccountViewModel(String id, String email, String fullname, String password, String address, String phone,
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
