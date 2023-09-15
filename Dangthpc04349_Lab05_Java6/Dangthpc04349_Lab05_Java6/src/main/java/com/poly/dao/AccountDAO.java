package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.bean.Account;

public interface AccountDAO extends JpaRepository<Account, String>{

}
