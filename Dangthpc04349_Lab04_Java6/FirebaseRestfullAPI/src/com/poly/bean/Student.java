/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author ADMIN
 */
public class Student {
    String email;
    String fullname;
    Double marks;
    Boolean gender;
    String country;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Student() {
    }

    public Student(String email, String fullname, Double marks, Boolean gender, String country) {
        this.email = email;
        this.fullname = fullname;
        this.marks = marks;
        this.gender = gender;
        this.country = country;
    }
    
    @JsonIgnore
    public Object[] getArray(){
        return new Object[]{
            getEmail(),
            getFullname(),
            getMarks(),
            getGender(),
            getCountry()
        };
    }
}
