package com.myclass.repository;

import java.util.List;

import com.myclass.entity.Delivery;


public interface DeliveryRepository {
	
	List<Delivery> findAll();
	
	Delivery findById(String id);
	
	boolean insert(Delivery delivery);
}
