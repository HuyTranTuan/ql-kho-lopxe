package com.myclass.service;

import java.util.List;
import java.util.Map;

import com.myclass.entity.Customer;
import com.myclass.model.CustomerModel;

public interface CustomerService {

	public List<Customer> findAll();
	
	public Customer findById(int id);
	
	public int findIdByName(String name);
	
	public boolean insert(CustomerModel customerModel);
	
	public boolean update(CustomerModel customerModel);
	
	public boolean delete(int id);
	
	Map<String, String> getAllDropdown();
}