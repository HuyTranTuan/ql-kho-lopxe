package com.myclass.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myclass.model.RegisterViewModel;
import com.myclass.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {
	@Autowired
	AccountService accountService;
	
	@PostMapping(value = "/register",
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody // Trả về kiểu dữ liệu JSON hoặc XML
	public Object register(@RequestBody RegisterViewModel model) {
		
		Map<String, String> obj = new HashMap<String, String>();
		
		if(accountService.checkEmailValid(model.getEmail())) {
			obj.put("status", "true");
			obj.put("message", "Tài khoản đã tồn tại!");
			return obj;
		}
		
		if(accountService.register(model)) {
			obj.put("status", "true");
			obj.put("message", "Đăng kí tài khoản thành công!");
		}
		else {
			obj.put("status", "false");
			obj.put("message", "Đăng kí tài khoản thất bại!");
		}
		return obj;
	}
}
