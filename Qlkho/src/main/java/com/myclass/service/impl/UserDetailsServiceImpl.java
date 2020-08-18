//package com.myclass.service.impl;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.myclass.entity.Account;
//import com.myclass.entity.Role;
//import com.myclass.model.CustomUserDetails;
//import com.myclass.repository.AccountRepository;
//
//@Service("userDetailsService")
//public class UserDetailsServiceImpl implements UserDetailsService{
//
//	@Autowired
//	AccountRepository accountRepository;
//	
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Account account = accountRepository.findByEmail(username);
//		if(account == null) {
//			throw new UsernameNotFoundException("Không tìm thấy tài khoản");
//		}
//		
//		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
//		Role role = account.getRole();
//		authorities.add(new SimpleGrantedAuthority(role.getName()));
//		
//		CustomUserDetails  userDetails = new CustomUserDetails(account.getEmail(), account.getPassword(), authorities);
//		userDetails.setFullname(account.getFullname());
//		
//		return userDetails;
//	}
//
//}
