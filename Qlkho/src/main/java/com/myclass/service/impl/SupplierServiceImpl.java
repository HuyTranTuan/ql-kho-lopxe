package com.myclass.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.Supplier;
import com.myclass.model.SupplierModel;
import com.myclass.repository.SupplierRepository;
import com.myclass.service.SupplierService;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	SupplierRepository supplierRepository;

	public List<Supplier> findAll() {
		return supplierRepository.findAll();
	}

	public Supplier findById(int id) {
		return supplierRepository.findById(id);
	}

	public int findIdByName(String name) {
		return supplierRepository.findIdByName(name);
	}

	public boolean insert(SupplierModel supplierModel) {
		try {
			Supplier supplier = new Supplier();
			supplier.setId(supplierModel.getId());
			supplier.setName(supplierModel.getName());
			supplier.setPhone(supplierModel.getPhone());
			supplier.setAddress(supplierModel.getAddress());
			return supplierRepository.insert(supplier);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(SupplierModel supplierModel) {
		try {
			Supplier supplier = supplierRepository.findById(supplierModel.getId());
			supplier.setName(supplierModel.getName());
			supplier.setPhone(supplierModel.getPhone());
			supplier.setAddress(supplierModel.getAddress());
			return supplierRepository.update(supplier);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int id) {
		return supplierRepository.delete(id);
	}
}
