package com.myclass.service;

import java.util.List;
import java.util.Map;

import com.myclass.entity.Role;
import com.myclass.model.RoleViewModel;

public interface RoleService {
	
	public List<Role> findAll();
	
	public Role findById(int id);
	
	public int findIdByName(String name);
	
	public boolean insert(RoleViewModel roleViewModel);
	
	public boolean update(RoleViewModel roleViewModel);
	
	public boolean delete(int id);
	
	Map<String, String> getAllDropdown();
}