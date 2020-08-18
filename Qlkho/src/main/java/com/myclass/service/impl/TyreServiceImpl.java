package com.myclass.service.impl;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.Tyre;
import com.myclass.model.TyreViewModel;
import com.myclass.repository.DeliveryRepository;
import com.myclass.repository.ReceivingRepository;
import com.myclass.repository.TyreRepository;
import com.myclass.service.TyreService;

@Service
@Transactional
public class TyreServiceImpl implements TyreService{

	@Autowired
	TyreRepository tyreRepository;
	
	@Autowired
	ReceivingRepository receivingRepository;
	
	@Autowired
	DeliveryRepository deliveryRepository;

	public Tyre findById(String id) {
		return tyreRepository.findById(id);
	}

	public List<Tyre> findAll() {
		return tyreRepository.findAll();
	}

	public boolean insert(TyreViewModel tyreViewModel) {
		try {
			Tyre tyre = new Tyre();
			tyre.setId(tyreViewModel.getId());
			tyre.setName(tyreViewModel.getName());
			tyre.setBrand(tyreViewModel.getBrand());
			tyre.setQuantity(tyreViewModel.getQuantity());
			tyre.setType(tyreViewModel.getType());
			tyre.setPrice(tyreViewModel.getPrice());
			tyre.setCreate(new Date());
			return tyreRepository.insert(tyre);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(TyreViewModel tyreViewModel) {
		try {
			Tyre tyre = tyreRepository.findById(tyreViewModel.getId());
			tyre.setName(tyreViewModel.getName());
			tyre.setBrand(tyreViewModel.getBrand());
			tyre.setType(tyreViewModel.getType());
			return tyreRepository.update(tyre);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(String id) {
		return tyreRepository.delete(id);
	}

	public String findIdByName(String name) {
		return tyreRepository.findIdByName(name);
	}
}
