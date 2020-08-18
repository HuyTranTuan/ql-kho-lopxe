package com.myclass.service;

import java.util.List;

import com.myclass.entity.Tyre;
import com.myclass.model.TyreViewModel;

public interface TyreService {

	public Tyre findById(String id);
	
	public List<Tyre> findAll();
	
	public String findIdByName(String name);
	
	public boolean insert(TyreViewModel tyreViewModel);
	
	public boolean update(TyreViewModel tyreViewModel);
	
	public boolean delete(String id);
}
