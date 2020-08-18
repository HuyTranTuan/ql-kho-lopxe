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

import com.myclass.entity.Supplier;
import com.myclass.model.SupplierModel;
import com.myclass.service.SupplierService;

@Controller
@RequestMapping("/admin/ncc")
public class AdminSupplierController {

	@Autowired
	SupplierService supplierService;
	
	@GetMapping("")
	public String ncc(Model model, HttpSession session) {
		if(session.getAttribute("msgSuccess") != null) {
			model.addAttribute("msgSuccess", session.getAttribute("msgSuccess").toString());
			session.removeAttribute("msgSuccess");
		}
		else if(session.getAttribute("msgError") != null){
			model.addAttribute("msgError", session.getAttribute("msgError").toString());
			session.removeAttribute("msgError");
		}
		List<Supplier> list = supplierService.findAll();
		model.addAttribute("suppliers",list);
		return "adminSupplier";
	}
	
	@GetMapping("add")
	public String themNcc(Model model) {
		model.addAttribute("supplier", new SupplierModel());
		return "adminSupplierAdd";
	}
	
	@PostMapping("add")
	public String postThemNcc(Model model, 
			@Validated @ModelAttribute("supplier") SupplierModel supplierModel,
			BindingResult errors, HttpSession session) {
		if(errors.hasErrors()) {
			model.addAttribute("supplier", supplierModel);
			return "adminSupplierAdd"; 
		}
		if(supplierService.insert(supplierModel)) {
			session.setAttribute("msgSuccess","Thêm mới thành công");
			return "redirect:/admin/ncc";
		}
		else {
			model.addAttribute("msgError", "Thêm mới thất bại!");
		}
		model.addAttribute("supplier", supplierModel);
		return "adminSupplierAdd";
	}
	
	@GetMapping("delete/{id}")
	public String xoaNcc(Model model, @PathVariable("id") int id,
			HttpSession session) {
		if(supplierService.delete(id)){
			session.setAttribute("msgSuccess","Xóa thành công");
		}
		model.addAttribute("msgError","Xóa thất bại!");
		return "redirect:/admin/ncc";
	}
	
	@GetMapping("edit/{id}")
	public String suaNcc(Model model,  @PathVariable("id") int id) {
		model.addAttribute("supplier", supplierService.findById(id));
		return "adminSupplierEdit";
	}
	
	@PostMapping("edit")
	public String postSuaNcc(Model model, 
			@Validated @ModelAttribute("supplier") SupplierModel supplierModel,
			BindingResult errors, HttpSession session) {
		if(errors.hasErrors()) {
			model.addAttribute("supplier", supplierModel);
			return "adminSupplierEdit"; 
		}
		if(supplierService.update(supplierModel)) {
			session.setAttribute("msgSuccess","Cập nhật thành công");
			return "redirect:/admin/ncc";
		}
		else {
			model.addAttribute("msgError", "Cập nhật thất bại!");
		}
		model.addAttribute("supplier", supplierService);
		return "adminSupplierEdit";
	}
}
