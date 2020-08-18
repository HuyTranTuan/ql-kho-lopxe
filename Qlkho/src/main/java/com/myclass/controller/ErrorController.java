package com.myclass.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

@ControllerAdvice
public class ErrorController {

	@GetMapping("error/404")
	public String notFound() {
		return "redirect:/error/404";
	}
	
	public String error() {
		return "redirect:/error/500";
	}
}
