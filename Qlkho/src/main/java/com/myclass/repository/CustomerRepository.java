package com.myclass.repository;

import java.util.List;

import com.myclass.entity.Customer;

public interface CustomerRepository {

	List<Customer> findAll();
	
	Customer findById(int id);
	
	int findIdByName(String name);
	
	boolean insert(Customer customer);
	
	boolean update(Customer customer);
	
	boolean delete(int id);
}
