package com.myclass.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.entity.Delivery;
import com.myclass.entity.Receiving;
import com.myclass.service.DeliveryService;
import com.myclass.service.ReceivingService;

@Controller
@RequestMapping("/admin/bao-cao")
public class AdminReport {

	@Autowired
	ReceivingService receivingService;
	
	@Autowired
	DeliveryService deliveryService;
	
	@GetMapping("")
	public String thanhVien(Model model, HttpSession session) {
		if(session.getAttribute("msgSuccess") != null) {
			model.addAttribute("msgSuccess", session.getAttribute("msgSuccess").toString());
			session.removeAttribute("msgSuccess");
		}
		else if(session.getAttribute("msgError") != null){
			model.addAttribute("msgError", session.getAttribute("msgError").toString());
			session.removeAttribute("msgError");
		}
		List<Receiving> list = receivingService.findAll();
		model.addAttribute("receivings",list);
		List<Delivery> list2 = deliveryService.findAll();
		model.addAttribute("deliveries",list2);
		return "adminReport";
	}
}
