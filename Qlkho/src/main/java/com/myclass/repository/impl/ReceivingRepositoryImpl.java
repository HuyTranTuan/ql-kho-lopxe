package com.myclass.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Receiving;
import com.myclass.repository.ReceivingRepository;

@Repository
@Transactional
public class ReceivingRepositoryImpl implements ReceivingRepository{

	@Autowired
	SessionFactory sessionFactory;
	
	public List<Receiving> findAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.createQuery("from receiving",Receiving.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Receiving findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.get(Receiving.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insert(Receiving receiving) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(receiving);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
