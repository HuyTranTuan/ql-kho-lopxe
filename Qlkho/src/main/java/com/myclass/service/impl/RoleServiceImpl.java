package com.myclass.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.Role;
import com.myclass.model.RoleViewModel;
import com.myclass.repository.RoleRepository;
import com.myclass.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleRepository;
	
	public int findIdByName(String name) {
		return roleRepository.findIdByName(name);
	}

	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	public boolean delete(int id) {
		return roleRepository.delete(id);
	}

	public boolean insert(RoleViewModel roleViewModel) {
		try {
			Role role = new Role();
			role.setId(roleViewModel.getId());
			role.setDescription(roleViewModel.getDescription());
			role.setName(roleViewModel.getName());
			return roleRepository.insert(role);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(RoleViewModel roleViewModel) {
		try {
			Role role = roleRepository.findById(roleViewModel.getId());
			role.setDescription(roleViewModel.getDescription());
			role.setName(roleViewModel.getName());
			return roleRepository.update(role);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Map<String, String> getAllDropdown() {
		List<Role> list = roleRepository.findAll();
		Map<String, String> map = new HashMap<String, String>();
		for(Role role : list) {
			map.put(Integer.valueOf(role.getId()).toString(), role.getDescription());
		}
		return map;
	}

	public Role findById(int id) {
		return roleRepository.findById(id);
	}
	
}
