package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poly.bean.Category;
import com.poly.dao.CategoryDAO;

@CrossOrigin("*")
@RestController
public class CategoryController {
	@Autowired
	CategoryDAO dao;

	@GetMapping("/rest/categories")
	public ResponseEntity<List<Category>> getAll(Model model) {
		return ResponseEntity.ok(dao.findAll());
	}

	@GetMapping("/rest/categories/{id}")
	public ResponseEntity<Category> getOne(@PathVariable("id") String id) {
		if (!dao.existsById(id))
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(dao.findById(id).get());
	}
	
	@PostMapping("/rest/categories")
	public ResponseEntity<Category> post(@RequestBody Category category){
		if(dao.existsById(category.getId())) {
			return ResponseEntity.badRequest().build();
		}
		dao.save(category);
		return ResponseEntity.ok(category);
	}
	
	@PutMapping("/rest/categories{id}")
	public ResponseEntity<Category> put(@PathVariable("id") String id, @RequestBody Category category){
		if(dao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		dao.save(category);
		return ResponseEntity.ok(category);
	}
	
	@DeleteMapping("/rest/categories{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String id){
		if(dao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		dao.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
