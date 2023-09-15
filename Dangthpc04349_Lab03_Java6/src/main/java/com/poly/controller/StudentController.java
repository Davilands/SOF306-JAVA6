package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.bean.Student;

@Controller
public class StudentController {
	@GetMapping("/student/form")
	public String form(Model model) {
		Student sv = new Student();
		sv.setFullname("Nguyễn Văn Tèo");
		sv.setCountry("VN");
		sv.setGender(true);
		
		model.addAttribute("sv", sv);
		return "student/form";
	}
	
	@PostMapping("/student/save")
	public String save(@ModelAttribute("sv") Student form) {
		return "student/success";
	}
	
}
