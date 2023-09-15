package com.poly.lab;

import java.io.File;
import java.io.IOException;

import javax.security.auth.Subject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson1 {
public static void main(String[] args) throws IOException {
//	demo1();
	demo2();
}

private static void demo2() throws IOException {
	String path = "src//main//resources//students.json";
	ObjectMapper mapper = new ObjectMapper();
	JsonNode students = mapper.readTree(new File(path));
	students.iterator().forEachRemaining(student -> {
		System.out.println(">> Name : "+student.get("name").asText());
	});
	
}

private static void demo1() throws IOException {
	String path = "src//main//resources//student.json";
	ObjectMapper mapper = new ObjectMapper();
	JsonNode student = mapper.readTree(new File(path));
	
	System.out.println(">> Name : "+student.get("name").asText());
	System.out.println(">> Marks : "+student.get("marks").asDouble());
	System.out.println(">> Gender : "+student.get("gender").asBoolean());
	System.out.println(">> Email : "+student.get("contact").get("email").asText());
	System.out.println(">> Phone : "+student.findValue("phone").asText());
	student.get("subject").iterator().forEachRemaining(subject ->{
		System.out.println(">> Subject : "+subject.asText());
	});

	
}
}
