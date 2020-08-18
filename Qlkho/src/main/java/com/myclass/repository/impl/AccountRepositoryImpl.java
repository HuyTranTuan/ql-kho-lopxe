package com.myclass.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Account;
import com.myclass.repository.AccountRepository;

@Repository
@Transactional
public class AccountRepositoryImpl implements AccountRepository{

	@Autowired
	SessionFactory sessionFactory;
	
	public List<Account> findAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.createQuery("from accounts",Account.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Account findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.get(Account.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Account> findPaging(int pageIndex, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Query<Account> query = session.createQuery("from accounts",Account.class);
				int position = (pageIndex -1) * pageSize;
				query.setFirstResult(position);
				query.setMaxResults(pageSize);
				return query.getResultList();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Account> search(String keyword, int pageIndex, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sqlQuery = "from accounts where email like :email or fullname like :fullname";
			Query<Account> query = session.createQuery(sqlQuery,Account.class);
				query.setParameter("email","%" + keyword + "%");
				query.setParameter("fullname","%" + keyword + "%");
				int position = (pageIndex -1) * pageSize;
				query.setFirstResult(position);
				query.setMaxResults(pageSize);
				return query.getResultList();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insert(Account account) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(account);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Account account) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(account);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Account account = session.byId(Account.class).load(id);
			session.delete(account);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Account findByEmail(String email) {
		String a = "from accounts where email = :email";
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<Account> query = session.createQuery(a,Account.class);
			query.setParameter("email", email);
			return query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
