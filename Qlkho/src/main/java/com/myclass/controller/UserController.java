package com.myclass.controller;

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
import com.myclass.entity.Delivery;
import com.myclass.entity.Receiving;
import com.myclass.entity.Supplier;
import com.myclass.entity.Tyre;
import com.myclass.model.CustomerModel;
import com.myclass.model.DeliveryModel;
import com.myclass.model.ReceivingModel;
import com.myclass.model.SupplierModel;
import com.myclass.model.TyreViewModel;
import com.myclass.service.CustomerService;
import com.myclass.service.DeliveryService;
import com.myclass.service.ReceivingService;
import com.myclass.service.SupplierService;
import com.myclass.service.TyreService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	TyreService tyreService;
	
	@Autowired
	ReceivingService receivingService;
	
	@Autowired
	DeliveryService deliveryService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	SupplierService supplierService;
	
	@GetMapping("")
	public String index() {
		return "userIndex";
	}
	
	@GetMapping("san-pham")
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
		return "userProduct";
	}
	
	@GetMapping("san-pham/add")
	public String themSanPham(Model model) {
		model.addAttribute("tyre", new TyreViewModel());
		return "userProductAdd";
	}
	
	@PostMapping("san-pham/add")
	public String postThemSanPham(Model model, 
			@Validated @ModelAttribute("tyre") TyreViewModel tyreViewModel,
			BindingResult errors, HttpSession session) {
		if(errors.hasErrors()) {
			model.addAttribute("tyre", tyreViewModel);
			return "userProductAdd"; 
		}
		if(tyreService.insert(tyreViewModel)) {
			session.setAttribute("msgSuccess","Thêm mới thành công");
			return "redirect:/user/san-pham";
		}
		else {
			model.addAttribute("msgError", "Thêm mới thất bại!");
		}
		model.addAttribute("tyre", tyreViewModel);
		return "userProductAdd";
	}
	
	@GetMapping("san-pham/delete/{id}")
	public String xoaSanPham(Model model, @PathVariable("id") String id,
			HttpSession session) {
		if(tyreService.delete(id)){
			session.setAttribute("msgSuccess","Xóa thành công");
		}
		model.addAttribute("msgError","Xóa thất bại!");
		return "redirect:/user/san-pham";
	}
	
	@GetMapping("san-pham/edit/{id}")
	public String suaSanPham(Model model,  @PathVariable("id") String id) {
		model.addAttribute("tyre", tyreService.findById(id));
		return "userProductEdit";
	}
	
	@PostMapping("san-pham/edit")
	public String postSuaSanPham(Model model, 
			@Validated @ModelAttribute("tyre") TyreViewModel tyreViewModel,
			BindingResult errors, HttpSession session) {
		if(errors.hasErrors()) {
			model.addAttribute("tyre", tyreViewModel);
			return "userProductEdit"; 
		}
		if(tyreService.update(tyreViewModel)) {
			session.setAttribute("msgSuccess","Cập nhật thành công");
			return "redirect:/user/san-pham";
		}
		else {
			model.addAttribute("msgError", "Cập nhật thất bại!");
		}
		model.addAttribute("tyre", tyreService);
		return "userProductEdit";
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("nhap-kho")
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
		return "userReceiving";
	}
	
	@GetMapping("nhap-kho/add")
	public String themNhapKho(Model model) {
		model.addAttribute("receiving", new ReceivingModel());
		return "userReceivingAdd";
	}
	
	@PostMapping("nhap-kho/add")
	public String postThemNhapKho(Model model, 
			@Validated @ModelAttribute("receiving") ReceivingModel receivingModel,
			BindingResult errors, HttpSession session) {
		if(errors.hasErrors()) {
			model.addAttribute("receiving", receivingModel);
			return "userReceivingAdd"; 
		}
		if(receivingService.insert(receivingModel)) {
			session.setAttribute("msgSuccess","Thêm mới thành công");
			return "redirect:/user/nhap-kho";
		}
		else {
			model.addAttribute("msgError", "Thêm mới thất bại!");
		}
		model.addAttribute("receiving", receivingModel);
		return "userReceivingAdd";
	}
	
	/////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////
	
	@GetMapping("xuat-kho")
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
		return "userDelivery";
	}
	
	@GetMapping("xuat-kho/add")
	public String themXuatKho(Model model) {
		model.addAttribute("delivery", new DeliveryModel());
		return "userDeliveryAdd";
	}
	
	@PostMapping("xuat-kho/add")
	public String postThemXuatKho(Model model, 
			@Validated @ModelAttribute("delivery") DeliveryModel deliveryModel,
			BindingResult errors, HttpSession session) {
		if(errors.hasErrors()) {
			return "userDeliveryAdd"; 
		}
		if(deliveryService.insert(deliveryModel)) {
			session.setAttribute("msgSuccess","Thêm mới thành công");
			return "redirect:/user/xuat-kho";
		}
		else {
			model.addAttribute("msgError", "Thêm mới thất bại!");
		}
		model.addAttribute("delivery", deliveryModel);
		return "userDeliveryAdd";
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("khach-hang")
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
		return "userCustomer";
	}
	
	@GetMapping("khach-hang/add")
	public String themKhachHang(Model model) {
		model.addAttribute("customer", new CustomerModel());
		return "userCustomerAdd";
	}
	
	@PostMapping("khach-hang/add")
	public String postThemKhachHang(Model model, 
			@Validated @ModelAttribute("customer") CustomerModel customerModel,
			BindingResult errors, HttpSession session) {
		if(errors.hasErrors()) {
			model.addAttribute("customer", customerModel);
			return "userCustomerAdd"; 
		}
		if(customerService.insert(customerModel)) {
			session.setAttribute("msgSuccess","Thêm mới thành công");
			return "redirect:/user/khach-hang";
		}
		else {
			model.addAttribute("msgError", "Thêm mới thất bại!");
		}
		model.addAttribute("customer", customerModel);
		return "userCustomerAdd";
	}
	
	@GetMapping("khach-hang/delete/{id}")
	public String xoaKhachHang(Model model, @PathVariable("id") int id,
			HttpSession session) {
		if(customerService.delete(id)){
			session.setAttribute("msgSuccess","Xóa thành công");
		}
		model.addAttribute("msgError","Xóa thất bại!");
		return "redirect:/user/khach-hang";
	}
	
	@GetMapping("khach-hang/edit/{id}")
	public String suaKhachHang(Model model,  @PathVariable("id") int id) {
		model.addAttribute("customer", customerService.findById(id));
		return "userCustomerEdit";
	}
	
	@PostMapping("khach-hang/edit")
	public String postSuaKhachHang(Model model, 
			@Validated @ModelAttribute("customer") CustomerModel customerModel,
			BindingResult errors, HttpSession session) {
		if(errors.hasErrors()) {
			model.addAttribute("customer", customerModel);
			return "userCustomerEdit"; 
		}
		if(customerService.update(customerModel)) {
			session.setAttribute("msgSuccess","Cập nhật thành công");
			return "redirect:/user/khach-hang";
		}
		else {
			model.addAttribute("msgError", "Cập nhật thất bại!");
		}
		model.addAttribute("customer", customerService);
		return "userCustomerEdit";
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	@GetMapping("ncc")
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
		return "userSupplier";
	}
	
	@GetMapping("ncc/add")
	public String themNcc(Model model) {
		model.addAttribute("supplier", new SupplierModel());
		return "userSupplierAdd";
	}
	
	@PostMapping("ncc/add")
	public String postThemNcc(Model model, 
			@Validated @ModelAttribute("supplier") SupplierModel supplierModel,
			BindingResult errors, HttpSession session) {
		if(errors.hasErrors()) {
			model.addAttribute("supplier", supplierModel);
			return "userSupplierAdd"; 
		}
		if(supplierService.insert(supplierModel)) {
			session.setAttribute("msgSuccess","Thêm mới thành công");
			return "redirect:/user/ncc";
		}
		else {
			model.addAttribute("msgError", "Thêm mới thất bại!");
		}
		model.addAttribute("supplier", supplierModel);
		return "userSupplierAdd";
	}
	
	@GetMapping("ncc/delete/{id}")
	public String xoaNcc(Model model, @PathVariable("id") int id,
			HttpSession session) {
		if(supplierService.delete(id)){
			session.setAttribute("msgSuccess","Xóa thành công");
		}
		model.addAttribute("msgError","Xóa thất bại!");
		return "redirect:/user/ncc";
	}
	
	@GetMapping("ncc/edit/{id}")
	public String suaNcc(Model model,  @PathVariable("id") int id) {
		model.addAttribute("supplier", supplierService.findById(id));
		return "userSupplierEdit";
	}
	
	@PostMapping("ncc/edit")
	public String postSuaNcc(Model model, 
			@Validated @ModelAttribute("supplier") SupplierModel supplierModel,
			BindingResult errors, HttpSession session) {
		if(errors.hasErrors()) {
			model.addAttribute("supplier", supplierModel);
			return "userSupplierEdit"; 
		}
		if(supplierService.update(supplierModel)) {
			session.setAttribute("msgSuccess","Cập nhật thành công");
			return "redirect:/admin/ncc";
		}
		else {
			model.addAttribute("msgError", "Cập nhật thất bại!");
		}
		model.addAttribute("supplier", supplierService);
		return "userSupplierEdit";
	}
	
	@GetMapping("bao-cao")
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
		return "userReport";
	}
}
