package com.myclass.repository;

import java.util.List;

import com.myclass.entity.Receiving;

public interface ReceivingRepository {

	List<Receiving> findAll();
	
	Receiving findById(String id);
	
	boolean insert(Receiving receiving);
}
