package com.myclass.service;

import java.util.List;

import com.myclass.entity.Supplier;
import com.myclass.model.SupplierModel;

public interface SupplierService {

	public List<Supplier> findAll();
	
	public Supplier findById(int id);
	
	public int findIdByName(String name);
	
	public boolean insert(SupplierModel supplierModel);
	
	public boolean update(SupplierModel supplierModel);
	
	public boolean delete(int id);
}
