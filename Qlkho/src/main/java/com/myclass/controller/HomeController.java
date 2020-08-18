package com.myclass.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.entity.Role;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	SessionFactory sessionFactory;
	
	@GetMapping("")
	@Transactional //quản lý giao dịch 1 cách tự động, sau khi hoàn thành giao dịch sẽ tự đóng session nên ta không cần code tay đóng
	public String index() {
		Session session = sessionFactory.openSession();
		try {
			List<Role> list = session.createQuery("from roles",Role.class).list();
			for(Role item:list) {
				System.out.println(item.getDescription());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "homeIndex";
	}
}
