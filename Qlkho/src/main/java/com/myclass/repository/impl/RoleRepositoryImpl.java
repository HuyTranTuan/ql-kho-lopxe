package com.myclass.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;

@Repository
@Transactional
public class RoleRepositoryImpl implements RoleRepository{

	@Autowired
	SessionFactory sessionFactory;
	
	public int findIdByName(String name) {
		String a = "select id from roles where name = :name";
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<Role> query = session.createQuery(a,Role.class);
			query.setParameter("name", name);
			int id = Integer.parseInt(query.uniqueResult().toString());
			return id;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public List<Role> findAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.createQuery("from roles",Role.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insert(Role role) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(role);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(Role role) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(role);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Role role = session.byId(Role.class).load(id);
			session.delete(role);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Role findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.get(Role.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
