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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.entity.Customer;
import com.myclass.model.CustomerModel;
import com.myclass.service.CustomerService;

@Controller
@RequestMapping("/admin/khach-hang")
public class AdminCustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("")
	public String khachHang(Model model, HttpSession session) {
		if(session.getAttribute("msgSuccess") != null) {
			model.addAttribute("msgSuccess", session.getAttribute("msgSuccess").toString());
			session.removeAttribute("msgSuccess");
		}
		else if(session.getAttribute("msgError") != null){
			model.addAttribute("msgError", session.getAttribute("msgError").toString());
			session.removeAttribute("msgError");
		}
		List<Customer> list = customerService.findAll();
		model.addAttribute("customers",list);
		return "adminCustomer";
	}
	
	@GetMapping("add")
	public String themKhachHang(Model model) {
		model.addAttribute("customer", new CustomerModel());
		return "adminCustomerAdd";
	}
	
	@PostMapping("add")
	public String postThemKhachHang(Model model, 
			@Validated @ModelAttribute("customer") CustomerModel customerModel,
			BindingResult errors, HttpSession session) {
		if(errors.hasErrors()) {
			model.addAttribute("customer", customerModel);
			return "adminCustomerAdd"; 
		}
		if(customerService.insert(customerModel)) {
			session.setAttribute("msgSuccess","Thêm mới thành công");
			return "redirect:/admin/khach-hang";
		}
		else {
			model.addAttribute("msgError", "Thêm mới thất bại!");
		}
		model.addAttribute("customer", customerModel);
		return "adminCustomerAdd";
	}
	
	@GetMapping("delete/{id}")
	public String xoaKhachHang(Model model, @PathVariable("id") int id,
			HttpSession session) {
		if(customerService.delete(id)){
			session.setAttribute("msgSuccess","Xóa thành công");
		}
		model.addAttribute("msgError","Xóa thất bại!");
		return "redirect:/user/khach-hang";
	}
	
	@GetMapping("edit/{id}")
	public String suaKhachHang(Model model,  @PathVariable("id") int id) {
		model.addAttribute("customer", customerService.findById(id));
		return "adminCustomerEdit";
	}
	
	@PostMapping("edit")
	public String postSuaKhachHang(Model model, 
			@Validated @ModelAttribute("customer") CustomerModel customerModel,
			BindingResult errors, HttpSession session) {
		if(errors.hasErrors()) {
			model.addAttribute("customer", customerModel);
			return "adminCustomerEdit"; 
		}
		if(customerService.update(customerModel)) {
			session.setAttribute("msgSuccess","Cập nhật thành công");
			return "redirect:/admin/khach-hang";
		}
		else {
			model.addAttribute("msgError", "Cập nhật thất bại!");
		}
		model.addAttribute("customer", customerService);
		return "adminCustomerEdit";
	}
}
