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

import com.myclass.entity.Receiving;
import com.myclass.model.ReceivingModel;
import com.myclass.service.ReceivingService;

@Controller
@RequestMapping("/admin/nhap-kho")
public class AdminReceivingController {

	@Autowired
	ReceivingService receivingService;
	
	@GetMapping("")
	public String nhapKho(Model model, HttpSession session) {
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
		return "adminReceiving";
	}
	
	@GetMapping("add")
	public String themNhapKho(Model model) {
		model.addAttribute("receiving", new ReceivingModel());
		return "adminReceivingAdd";
	}
	
	@PostMapping("add")
	public String postThemNhapKho(Model model, 
			@Validated @ModelAttribute("receiving") ReceivingModel receivingModel,
			BindingResult errors, HttpSession session) {
		if(errors.hasErrors()) {
			model.addAttribute("receiving", receivingModel);
			return "adminReceivingAdd"; 
		}
		if(receivingService.insert(receivingModel)) {
			session.setAttribute("msgSuccess","Thêm mới thành công");
			return "redirect:/admin/nhap-kho";
		}
		else {
			model.addAttribute("msgError", "Thêm mới thất bại!");
		}
		model.addAttribute("receiving", receivingModel);
		return "adminReceivingAdd";
	}
}
