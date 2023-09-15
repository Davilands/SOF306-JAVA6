package com.poly.dao;

import com.poly.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<Student, String>{

}
