package com.myclass.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Tyre;
import com.myclass.repository.TyreRepository;

@Repository
@Transactional
public class TyreRepositoryImpl implements TyreRepository{

	@Autowired
	SessionFactory sessionFactory;

	public List<Tyre> findAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.createQuery("from tyres",Tyre.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Tyre findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.get(Tyre.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insert(Tyre tyre) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(tyre);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Tyre tyre) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(tyre);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Tyre tyre = session.byId(Tyre.class).load(id);
			session.delete(tyre);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String findIdByName(String name) {
		String a = "select id from tyres where name = :name";
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<Tyre> query = session.createQuery(a,Tyre.class);
			query.setParameter("name", name);
			return query.uniqueResult().toString();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}
}
