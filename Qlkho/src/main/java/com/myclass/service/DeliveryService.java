package com.myclass.service;

import java.util.List;

import com.myclass.entity.Delivery;
import com.myclass.model.DeliveryModel;

public interface DeliveryService {

	public List<Delivery> findAll();
	
	public Delivery findById(String id);
	
	public boolean insert(DeliveryModel deliveryModel);
}
