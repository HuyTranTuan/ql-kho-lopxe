package com.myclass.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.entity.Delivery;
import com.myclass.model.DeliveryModel;
import com.myclass.service.DeliveryService;

@Controller
@RequestMapping("/admin/xuat-kho")
public class AdminDeliveryController {

	@Autowired
	DeliveryService deliveryService;
	
	@GetMapping("")
	public String xuatKho(Model model, HttpSession session) {
		if(session.getAttribute("msgSuccess") != null) {
			model.addAttribute("msgSuccess", session.getAttribute("msgSuccess").toString());
			session.removeAttribute("msgSuccess");
		}
		else if(session.getAttribute("msgError") != null){
			model.addAttribute("msgError", session.getAttribute("msgError").toString());
			session.removeAttribute("msgError");
		}
		List<Delivery> list = deliveryService.findAll();
		model.addAttribute("deliveries",list);
		return "adminDelivery";
	}
	
	@GetMapping("add")
	public String themXuatKho(Model model) {
		model.addAttribute("delivery", new DeliveryModel());
		return "adminDeliveryAdd";
	}
	
	@PostMapping("add")
	public String postThemXuatKho(Model model, 
			@Validated @ModelAttribute("delivery") DeliveryModel deliveryModel,
			BindingResult errors, HttpSession session) {
		if(errors.hasErrors()) {
			return "adminDeliveryAdd"; 
		}
		if(deliveryService.insert(deliveryModel)) {
			session.setAttribute("msgSuccess","Thêm mới thành công");
			return "redirect:/admin/xuat-kho";
		}
		else {
			model.addAttribute("msgError", "Thêm mới thất bại!");
		}
		return "adminDeliveryAdd";
	}
}
