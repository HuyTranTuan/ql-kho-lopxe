package com.myclass.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.Customer;
import com.myclass.model.CustomerModel;
import com.myclass.repository.CustomerRepository;
import com.myclass.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	public Customer findById(int id) {
		return customerRepository.findById(id);
	}

	public int findIdByName(String name) {
		return customerRepository.findIdByName(name);
	}

	public boolean insert(CustomerModel customerModel) {
		try {
			Customer customer = new Customer();
			customer.setId(customerModel.getId());
			customer.setName(customerModel.getName());
			customer.setPhone(customerModel.getPhone());
			customer.setAddress(customerModel.getAddress());
			return customerRepository.insert(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(CustomerModel customerModel) {
		try {
			Customer customer = customerRepository.findById(customerModel.getId());
			customer.setName(customerModel.getName());
			customer.setPhone(customerModel.getPhone());
			customer.setAddress(customerModel.getAddress());
			return customerRepository.update(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int id) {
		return customerRepository.delete(id);
	}

	public Map<String, String> getAllDropdown() {
		List<Customer> list = customerRepository.findAll();
		Map<String, String> map = new HashMap<String, String>();
		for(Customer customer : list) {
			map.put(Integer.valueOf(customer.getId()).toString(), customer.getName());
		}
		return map;
	}

}
