package com.poly.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.bean.Student1;

@Controller
public class StudentController {
@RequestMapping("/student")
public String index(Model model,@RequestParam("index")Optional<Integer> index) throws StreamReadException, DatabindException, IOException {
	ObjectMapper mapper = new ObjectMapper();
	File path = ResourceUtils.getFile("classpath:com/poly/bean/student.json");
	TypeReference<List<Student1>> typeref = new TypeReference<>() {
	};
		List<Student1> students = mapper.readValue(path, typeref);	
		
		int i = index.orElse(0);
	model.addAttribute("n", i);
	model.addAttribute("sv", students.get(i));
	
			return "scope/student";
}

}
