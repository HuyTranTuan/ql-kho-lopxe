package com.myclass.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Supplier;
import com.myclass.repository.SupplierRepository;

@Repository
@Transactional
public class SupplierRepositoryImpl implements SupplierRepository{
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Supplier> findAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.createQuery("from suppliers",Supplier.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Supplier findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.get(Supplier.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int findIdByName(String name) {
		String a = "select id from suppliers where name = :name";
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<Supplier> query = session.createQuery(a,Supplier.class);
			query.setParameter("name", name);
			int id = Integer.parseInt(query.uniqueResult().toString());
			return id;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public boolean insert(Supplier supplier) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Supplier supplier) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Supplier supplier = session.byId(Supplier.class).load(id);
			session.delete(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
