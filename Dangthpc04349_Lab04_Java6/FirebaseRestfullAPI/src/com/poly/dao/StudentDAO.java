/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.bean.Student;
import com.poly.bean.StudentMap;
import com.poly.rest.Rest;
import java.io.IOException;

/**
 *
 * @author ADMIN
 */
public class StudentDAO {
    ObjectMapper mapper = new ObjectMapper();
    
    public StudentMap findAll() throws IOException {
        JsonNode res = Rest.get("/Student");
        return mapper.convertValue(res, StudentMap.class);
    }
    
    public Student findByKey(String key) throws IOException {
        JsonNode res = Rest.get("/Student/"+key);
        return mapper.convertValue(res, Student.class);
    }
    
    public String create(Student data) throws IOException {
        JsonNode res = Rest.post("/Student",data);
        return res.get("name").asText();
    }
    
    public Student update(String key, Student data) throws IOException {
        System.out.println(key);
        JsonNode res = Rest.put("/Student/"+key,data);
        return mapper.convertValue(res, Student.class);
    }
    
    public void delete(String key) throws IOException {
       Rest.delete("/Student/"+key+"");
    }
}
