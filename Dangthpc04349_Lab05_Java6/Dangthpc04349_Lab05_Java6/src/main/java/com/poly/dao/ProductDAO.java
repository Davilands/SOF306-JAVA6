package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.bean.Product;

public interface ProductDAO extends JpaRepository<Product, String>{

}
