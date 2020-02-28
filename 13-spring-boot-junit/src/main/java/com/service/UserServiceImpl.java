package com.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.UserDaoImpl;

@Service
public class UserServiceImpl {

	@Resource
	private UserDaoImpl userDaoImpl;

	public void save() {
		this.userDaoImpl.saveUser();
	}

}
