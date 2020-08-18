package com.myclass.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.Delivery;
import com.myclass.model.DeliveryModel;
import com.myclass.repository.CustomerRepository;
import com.myclass.repository.DeliveryRepository;
import com.myclass.service.DeliveryService;

@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService{

	@Autowired
	DeliveryRepository deliveryRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	public List<Delivery> findAll() {
		return deliveryRepository.findAll();
	}

	public Delivery findById(String id) {
		return deliveryRepository.findById(id);
	}

	public boolean insert(DeliveryModel deliveryModel) {
		try {
			Delivery delivery = new Delivery();
			delivery.setId(UUID.randomUUID().toString());
			delivery.setQuantity(deliveryModel.getQuantity());
			delivery.setNote(deliveryModel.getNote());
			delivery.setActiveFlag(true);
			delivery.setCreate(new Date());
			delivery.setCustomer(deliveryModel.getCustomer());
			delivery.setTyre(deliveryModel.getTyre());
			return deliveryRepository.insert(delivery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
