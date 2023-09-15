package com.poly.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping("/home/index")
	public String index(Model model) {
		model.addAttribute("message","This is home page");
		return "home/index";
	}
	
	@RequestMapping("/home/about")
	public String about(Model model) {
		model.addAttribute("message","This is about page");
		return "home/index";
	}
	
//	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/home/admins")
	public String admins(Model model) {
		if(!request.isUserInRole("ADMIN")) {
			return "redirect:/auth/acccess/denied";
		}
		
		model.addAttribute("message","Hello admin");
		return "home/index";
	}
	
//	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@RequestMapping("/home/users")
	public String users(Model model) {
		if(!(request.isUserInRole("ADMIN") || request.isUserInRole("USER"))) {
			return "redirect:/auth/acccess/denied";
		}
		
		model.addAttribute("message","Hello staff");
		return "home/index";
	}
	
//	@PreAuthorize("isAuthenticated()")
	@RequestMapping("/home/authenticated")
	public String authenticated(Model model) {
		if(request.getRemoteUser() == null) {
			return "redirect:/auth/login/form";
		}
		
		model.addAttribute("message","This authenticated user");
		return "home/index";
	}
	
	@RequestMapping("/home/thymeleaf1")
	public String thymeleaf1(Model model) {
		model.addAttribute("message", "Thymeleaf - Without Extras");
		return "home/thymeleaf1";
	}
	
	@RequestMapping("/home/thymeleaf2")
	public String thymeleaf2(Model model) {
		try {
			model.addAttribute("message", "Thymeleaf - With Extras");
			return "home/thymeleaf2";
		} catch (Exception e) {
			System.out.println("Lỗi nè: " + e);
			throw e;
		}
	}
}
