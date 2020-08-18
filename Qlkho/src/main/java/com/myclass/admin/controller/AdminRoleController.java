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

import com.myclass.entity.Role;
import com.myclass.model.RoleViewModel;
import com.myclass.service.RoleService;

@Controller
@RequestMapping("/admin/quyen")
public class AdminRoleController {
	
	@Autowired
	RoleService roleService;
	
	//==============================================Trang quyền==============================================//
	@GetMapping("")
	public String quyen(Model model, HttpSession session) {
		if(session.getAttribute("msgSuccess") != null) {
			model.addAttribute("msgSuccess", session.getAttribute("msgSuccess").toString());
			session.removeAttribute("msgSuccess");
		}
		else if(session.getAttribute("msgError") != null){
			model.addAttribute("msgError", session.getAttribute("msgError").toString());
			session.removeAttribute("msgError");
		}
		List<Role> list = roleService.findAll();
		model.addAttribute("roles",list);
		return "adminRole";
	}
	
	@GetMapping("add")
	public String themQuyen(Model model) {
		model.addAttribute("role", new RoleViewModel());
		return "adminRoleAdd";
	}
	
	@PostMapping("add")
	public String postThemQuyen(Model model, 
			@Validated @ModelAttribute("role") RoleViewModel roleViewModel,
			BindingResult errors, HttpSession session) {
		if(errors.hasErrors()) {
			model.addAttribute("role", roleViewModel);
			return "adminRoleAdd"; 
		}
		if(roleService.insert(roleViewModel)) {
			session.setAttribute("msgSuccess","Thêm mới thành công");
			return "redirect:/admin/quyen";
		}
		else {
			model.addAttribute("msgError", "Thêm mới thất bại!");
		}
		model.addAttribute("role", roleViewModel);
		return "adminRoleAdd";
	}
	
	@GetMapping("delete/{id}")
	public String xoaQuyen(Model model, @PathVariable("id") int id,
			HttpSession session) {
		if(roleService.delete(id)) {
			session.setAttribute("msgSuccess","Xóa thành công");
		}
		model.addAttribute("msgError","Xóa thất bại!");
		return "redirect:/admin/quyen";
	}
	
	@GetMapping("edit/{id}")
	public String suaQuyen(Model model,  @PathVariable("id") int id) {
		model.addAttribute("role", roleService.findById(id));
		return "adminRoleEdit";
	}
	
	@PostMapping("edit")
	public String postSuaQuyen(Model model, 
			@Validated @ModelAttribute("role") RoleViewModel roleViewModel,
			BindingResult errors, HttpSession session) {
		if(errors.hasErrors()) {
			model.addAttribute("role", roleViewModel);
			return "adminRoleEdit"; 
		}
		if(roleService.update(roleViewModel)) {
			session.setAttribute("msgSuccess","Cập nhật thành công");
			return "redirect:/admin/quyen";
		}
		else {
			model.addAttribute("msgError", "Cập nhật thất bại!");
		}
		model.addAttribute("role", roleViewModel);
		return "adminRoleEdit";
	}
}
