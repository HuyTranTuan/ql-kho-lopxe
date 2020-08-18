package com.myclass.repository;

import java.util.List;

import com.myclass.entity.Supplier;

public interface SupplierRepository {

	List<Supplier> findAll();
	
	Supplier findById(int id);
	
	int findIdByName(String name);
	
	boolean insert(Supplier supplier);
	
	boolean update(Supplier supplier);
	
	boolean delete(int id);
}
