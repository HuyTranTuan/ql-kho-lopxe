package com.myclass.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.myclass.entity.Account;
import com.myclass.model.AccountViewModel;
import com.myclass.model.RegisterViewModel;
import com.myclass.repository.AccountRepository;
import com.myclass.repository.RoleRepository;
import com.myclass.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired 
	AccountRepository accountRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	public Account findById(String id) {
		return accountRepository.findById(id);
	}

	public List<Account> findPaging(int pageIndex, int pageSize) {
		return accountRepository.findPaging(pageIndex, pageSize);
	}

	public List<Account> search(String keyword, int pageIndex, int pageSize) {
		return accountRepository.search(keyword, pageIndex, pageSize);
	}

	public boolean insert(AccountViewModel accountViewModel) {
		try {
			Account account = new Account();
			account.setId(UUID.randomUUID().toString());
			account.setEmail(accountViewModel.getEmail());
			account.setPassword(BCrypt.hashpw(accountViewModel.getPassword(), BCrypt.gensalt(12)));
			account.setFullname(accountViewModel.getFullname());
			account.setActiveFlag(true);
			account.setRoleId(accountViewModel.getRoleId());
			account.setCreate(new Date());
			account.setUpdate(new Date());
			account.setAddress(accountViewModel.getAddress());
			account.setPhone(accountViewModel.getPhone());
			return accountRepository.insert(account);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(AccountViewModel accountViewModel) {
		try {
			Account account = accountRepository.findById(accountViewModel.getId());
			account.setEmail(accountViewModel.getEmail());
			account.setFullname(accountViewModel.getFullname());
			account.setRoleId(accountViewModel.getRoleId());
			account.setAddress(accountViewModel.getAddress());
			account.setPhone(accountViewModel.getPhone());
			account.setUpdate(new Date());
			return accountRepository.update(account);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(String id) {
		return accountRepository.delete(id);
	}

	public boolean register(RegisterViewModel model) {
		try {
			int roleId = roleRepository.findIdByName(model.getRoleType());
			Account account = new Account();
			account.setId(UUID.randomUUID().toString());
			account.setEmail(model.getEmail());
			account.setPassword(BCrypt.hashpw(model.getPassword(), BCrypt.gensalt(12)));
			account.setFullname(model.getFullname());
			account.setActiveFlag(true);
			account.setRoleId(roleId);
			account.setCreate(new Date());
			account.setUpdate(new Date());
			account.setAddress(model.getAddress());
			account.setPhone(model.getPhone());
			return accountRepository.insert(account);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkEmailValid(String email) {
		Account account = accountRepository.findByEmail(email);
		if(account != null) {
			return true;
		}
		return false;
	}

}
