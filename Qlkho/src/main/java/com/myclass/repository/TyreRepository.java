package com.myclass.repository;

import java.util.List;

import com.myclass.entity.Tyre;

public interface TyreRepository {
	
	List<Tyre> findAll();
	
	Tyre findById(String id);
	
	String findIdByName(String name);
	
	boolean insert(Tyre tyre);
	
	boolean update(Tyre tyre);
	
	boolean delete(String id);
}
