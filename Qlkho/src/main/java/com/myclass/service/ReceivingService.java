package com.myclass.service;

import java.util.List;

import com.myclass.entity.Receiving;
import com.myclass.model.ReceivingModel;

public interface ReceivingService {

	public List<Receiving> findAll();
	
	public Receiving findById(String id);
	
	public boolean insert(ReceivingModel receivingModel);
}
