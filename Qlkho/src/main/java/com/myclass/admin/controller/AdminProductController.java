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

import com.myclass.entity.Tyre;
import com.myclass.model.TyreViewModel;
import com.myclass.service.TyreService;

@Controller
@RequestMapping("/admin/san-pham")
public class AdminProductController {
	@Autowired
	TyreService tyreService;
	
	//==============================================Trang sản phẩm==============================================//
	@GetMapping("")
	public String sanPham(Model model, HttpSession session) {
		if(session.getAttribute("msgSuccess") != null) {
			model.addAttribute("msgSuccess", session.getAttribute("msgSuccess").toString());
			session.removeAttribute("msgSuccess");
		}
		else if(session.getAttribute("msgError") != null){
			model.addAttribute("msgError", session.getAttribute("msgError").toString());
			session.removeAttribute("msgError");
		}
		List<Tyre> list = tyreService.findAll();
		model.addAttribute("tyres",list);
		return "adminProduct";
	}
	
	@GetMapping("add")
	public String themSanPham(Model model) {
		model.addAttribute("tyre", new TyreViewModel());
		return "adminProductAdd";
	}
	
	@PostMapping("add")
	public String postThemSanPham(Model model, 
			@Validated @ModelAttribute("tyre") TyreViewModel tyreViewModel,
			BindingResult errors, HttpSession session) {
		if(errors.hasErrors()) {
			model.addAttribute("tyre", tyreViewModel);
			return "adminProductAdd"; 
		}
		if(tyreService.insert(tyreViewModel)) {
			session.setAttribute("msgSuccess","Thêm mới thành công");
			return "redirect:/admin/san-pham";
		}
		else {
			model.addAttribute("msgError", "Thêm mới thất bại!");
		}
		model.addAttribute("tyre", tyreViewModel);
		return "adminProductAdd";
	}
	
	@GetMapping("delete/{id}")
	public String xoaSanPham(Model model, @PathVariable("id") String id,
			HttpSession session) {
		if(tyreService.delete(id)){
			session.setAttribute("msgSuccess","Xóa thành công");
		}
		model.addAttribute("msgError","Xóa thất bại!");
		return "redirect:/admin/san-pham";
	}
	
	@GetMapping("edit/{id}")
	public String suaSanPham(Model model,  @PathVariable("id") String id) {
		model.addAttribute("tyre", tyreService.findById(id));
		return "adminProductEdit";
	}
	
	@PostMapping("edit")
	public String postSuaSanPham(Model model, 
			@Validated @ModelAttribute("tyre") TyreViewModel tyreViewModel,
			BindingResult errors, HttpSession session) {
		if(errors.hasErrors()) {
			model.addAttribute("tyre", tyreViewModel);
			return "adminProductEdit"; 
		}
		if(tyreService.update(tyreViewModel)) {
			session.setAttribute("msgSuccess","Cập nhật thành công");
			return "redirect:/admin/san-pham";
		}
		else {
			model.addAttribute("msgError", "Cập nhật thất bại!");
		}
		model.addAttribute("tyre", tyreService);
		return "adminProductEdit";
	}
}
