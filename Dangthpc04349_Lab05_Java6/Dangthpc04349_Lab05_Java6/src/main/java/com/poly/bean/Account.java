package com.poly.bean;



import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "Accounts")
public class Account  implements Serializable{
	@Id
	String username;
	String password;
	String fullname;
	String email;
	String photo;
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Order> orders;
	
}
