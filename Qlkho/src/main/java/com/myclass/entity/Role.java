package com.myclass.entity;

import java.util.Set;

import javax.persistence.*;

@Entity(name = "roles")
public class Role {

	@Id
	private int id;
	
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "role",fetch = FetchType.LAZY)
	private Set<Account> accounts;
	
	public Role() {}

	public Role(int id, String name, String description, Set<Account> accounts) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.accounts = accounts;
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

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	
	
}
