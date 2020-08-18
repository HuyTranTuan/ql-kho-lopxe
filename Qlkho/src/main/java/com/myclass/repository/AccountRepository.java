package com.myclass.repository;

import java.util.List;

import com.myclass.entity.Account;

public interface AccountRepository {

	List<Account> findAll();
	
	Account findById(String id);
	
	Account findByEmail(String email);
	
	List<Account> findPaging(int pageIndex, int pageSize);
	
	List<Account> search(String keyword, int pageIndex, int pageSize);
	
	boolean insert(Account account);
	
	boolean update(Account account);
	
	boolean delete(String id);
	
}
