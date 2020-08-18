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

import com.myclass.entity.Account;
import com.myclass.model.AccountViewModel;
import com.myclass.service.AccountService;
import com.myclass.service.RoleService;

@Controller
@RequestMapping("/admin/thanh-vien")
public class AdminUserController {
	@Autowired
	AccountService accountService;
	
	@Autowired
	RoleService roleService;
	
	//==============================================Trang thành viên==============================================//
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
		List<Account> list = accountService.findAll();
		model.addAttribute("accounts",list);
		return "adminUser";
	}
	
	@GetMapping("add")
	public String themThanhVien(Model model) {
		model.addAttribute("account", new AccountViewModel());
		model.addAttribute("roles",roleService.getAllDropdown());
		return "adminUserAdd";
	}
	
	@PostMapping("add")
	public String postThemThanhVien(Model model, 
			@Validated @ModelAttribute("account") AccountViewModel accountViewModel,
			BindingResult errors, HttpSession session) {
		if(errors.hasErrors()) {
			model.addAttribute("roles", roleService.getAllDropdown());
			return "adminUserAdd"; 
		}
		if(accountService.checkEmailValid(accountViewModel.getEmail())) {
			model.addAttribute("roles",roleService.getAllDropdown());
			model.addAttribute("msgSuccess", "Email đã tồn tại!");
			return "adminUserAdd";
		}
		if(accountService.insert(accountViewModel)) {
			session.setAttribute("msgSuccess","Thêm mới thành công");
			return "redirect:/admin/thanh-vien";
		}
		else {
			model.addAttribute("msgError", "Thêm mới thất bại!");
		}
		model.addAttribute("roles",roleService.getAllDropdown());
		return "adminUserAdd";
	}
	
	@GetMapping("delete/{id}")
	public String xoaThanhVien(Model model, @PathVariable("id") String id,
			HttpSession session) {
		if(accountService.delete(id)){
			session.setAttribute("msgSuccess","Xóa thành công");
		}
		model.addAttribute("msgError","Xóa thất bại!");
		return "redirect:/admin/thanh-vien";
	}
	
	@GetMapping("edit/{id}")
	public String suaThanhVien(Model model,  @PathVariable("id") String id) {
		model.addAttribute("account", accountService.findById(id));
		model.addAttribute("roles",roleService.getAllDropdown());
		return "adminUserEdit";
	}
	
	@PostMapping("edit")
	public String postSuaThanhVien(Model model, 
			@Validated @ModelAttribute("account") AccountViewModel accountViewModel,
			BindingResult errors, HttpSession session) {
		if(errors.hasErrors()) {
			model.addAttribute("roles", roleService.getAllDropdown());
			return "adminUserEdit"; 
		}
		if(accountService.update(accountViewModel)) {
			session.setAttribute("msgSuccess","Cập nhật thành công");
			return "redirect:/admin/thanh-vien";
		}
		else {
			model.addAttribute("msgError", "Cập nhật thất bại!");
		}
		model.addAttribute("roles",roleService.getAllDropdown());
		return "adminUserEdit";
	}
}
