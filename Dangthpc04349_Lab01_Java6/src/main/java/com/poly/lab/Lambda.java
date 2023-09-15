package com.poly.lab;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.poly.bean.Student;
public class Lambda {
	static List<Student> list = Arrays.asList(
			new Student("Nguyễn Văn Tèo",true,7.5),
			new Student("Trần Thị Thu Hương",false,5.5),
			new Student("Phạm Đức Cường",true,9.5),
			new Student("Lê Thị Mỹ Hồng",false,6.5),
			new Student("Đoàn Thị Kim Ý",false,8.0)
			);
public static void main(String[] args) {
	demo1();
	demo2();
	demo3();
	demo4();
}

private static void demo4() {
	Demo4Inter o = (x)->System.out.println(x);

	o.m1(2021);
	
}

private static void demo3() {
	Collections.sort(list,(sv1,sv2)->-sv1.getMarks().compareTo(sv2.getMarks()));
	list.forEach(sv -> {
		System.out.println(">> Name : "+sv.getName());
		System.out.println(">> Marks: "+sv.getMarks());
		System.out.println();
		
	});
	
}

private static void demo2() {
	
	list.forEach(sv -> {
		System.out.println(">> Name : "+sv.getName());
		System.out.println(">> Marks: "+sv.getMarks());
		System.out.println();
		
	});
	
}

private static void demo1() {
	List<Integer> list = Arrays.asList(1,9,4,7,5,2);
	list.forEach(n -> System.out.println(n));
	
}
@FunctionalInterface
interface Demo4Inter{
	void m1(int x);
	default void m2() {}
	public static void m3() {
		
	}
}
}
