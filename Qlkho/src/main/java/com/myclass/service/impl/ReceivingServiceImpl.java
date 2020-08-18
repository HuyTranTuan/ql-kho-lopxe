package com.myclass.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.Receiving;
import com.myclass.model.ReceivingModel;
import com.myclass.repository.CustomerRepository;
import com.myclass.repository.ReceivingRepository;
import com.myclass.repository.TyreRepository;
import com.myclass.service.ReceivingService;

@Service
@Transactional
public class ReceivingServiceImpl implements ReceivingService{

	@Autowired
	ReceivingRepository receivingRepository;
	
	@Autowired
	TyreRepository tyreRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	public List<Receiving> findAll() {
		return receivingRepository.findAll();
	}

	public Receiving findById(String id) {
		return receivingRepository.findById(id);
	}

	public boolean insert(ReceivingModel receivingModel) {
		try {
			Receiving receiving = new Receiving();
			receiving.setId(UUID.randomUUID().toString());
			receiving.setQuantity(receivingModel.getQuantity());
			receiving.setNote(receivingModel.getNote());
			receiving.setActiveFlag(true);
			receiving.setCreate(new Date());
			receiving.setCustomer(receivingModel.getCustomer());
			receiving.setTyre(receivingModel.getTyre());
			return receivingRepository.insert(receiving);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
