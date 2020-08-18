package com.myclass.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Delivery;
import com.myclass.repository.DeliveryRepository;

@Repository
@Transactional
public class DeliveryRepositoryImpl implements DeliveryRepository{

	@Autowired
	SessionFactory sessionFactory;
	
	public List<Delivery> findAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.createQuery("from delivery",Delivery.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Delivery findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.get(Delivery.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insert(Delivery delivery) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(delivery);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
