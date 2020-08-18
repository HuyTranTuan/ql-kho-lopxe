package com.myclass.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Customer;
import com.myclass.repository.CustomerRepository;

@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository{

	@Autowired
	SessionFactory sessionFactory;
	
	public List<Customer> findAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.createQuery("from customers",Customer.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Customer findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.get(Customer.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int findIdByName(String name) {
		String a = "select id from customers where name = :name";
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<Customer> query = session.createQuery(a,Customer.class);
			query.setParameter("name", name);
			int id = Integer.parseInt(query.uniqueResult().toString());
			return id;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public boolean insert(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(customer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(customer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Customer customer = session.byId(Customer.class).load(id);
			session.delete(customer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
