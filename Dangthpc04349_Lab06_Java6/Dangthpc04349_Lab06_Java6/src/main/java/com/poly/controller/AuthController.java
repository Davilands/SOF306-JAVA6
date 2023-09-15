package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {
	@RequestMapping("/auth/login/form")
	public String form() {
		return "auth/login";
	}
	
	@RequestMapping("/auth/login/success")
	public String success(Model model) {
		model.addAttribute("message","Đăng nhập thành công!");
		return "forward:/auth/login/form";
	}
	
	@RequestMapping("/auth/login/error")
	public String error(Model model) {
		model.addAttribute("message","Đăng nhập thất bại!");
		return "forward:/auth/login/form";
	}
	
	@RequestMapping("/auth/logout/success")
	public String logout(Model model) {
		model.addAttribute("message","Đăng xuất thành công!");
		return "forward:/auth/login/form";
	}
	
	@RequestMapping("/auth/acccess/denied")
	public String denied(Model model) {
		model.addAttribute("message","Bạn không có quyền truy xuất");
		return "auth/login";
	}
}
