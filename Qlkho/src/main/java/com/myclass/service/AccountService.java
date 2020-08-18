package com.myclass.service;

import java.util.List;

import com.myclass.entity.Account;
import com.myclass.model.AccountViewModel;
import com.myclass.model.RegisterViewModel;

public interface AccountService {

	public List<Account> findAll();
	
	public Account findById(String id);
	
	public List<Account> findPaging(int pageIndex, int pageSize);
	
	public List<Account> search(String keyword, int pageIndex, int pageSize);
	
	public boolean insert(AccountViewModel account);
	
	public boolean update(AccountViewModel account);
	
	public boolean delete(String id);
	
	public boolean register(RegisterViewModel model);
	
	public boolean checkEmailValid(String email);
}
