package com.myclass.repository;

import java.util.List;

import com.myclass.entity.Role;

public interface RoleRepository {

	List<Role> findAll();
	
	Role findById(int id);
	
	int findIdByName(String name);
	
	boolean insert(Role role);
	
	boolean update(Role role);
	
	boolean delete(int id);
}
