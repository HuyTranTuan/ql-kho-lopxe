//package com.myclass.model;
//
//import java.util.Collection;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//
//public class CustomUserDetails extends User implements UserDetails{
//
//	private static final long serialVersionUID = 1L;
//	
//	private String fullname;
//	
//	public String getFullname() {
//		return fullname;
//	}
//
//	public void setFullname(String fullname) {
//		this.fullname = fullname;
//	}
//
//	public CustomUserDetails(String username, String password, 
//			Collection<? extends GrantedAuthority> authorities) {
//		super(username, password, authorities);
//	}
//}
