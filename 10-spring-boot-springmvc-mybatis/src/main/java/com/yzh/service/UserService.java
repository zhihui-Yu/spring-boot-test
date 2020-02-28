package com.yzh.service;

import java.util.List;

import com.yzh.pojo.User;

public interface UserService {
	
	int addUser(User user);
	
	List<User> findUserAll();
	
	User findUserById(Integer id);
	
	void updateUser(User user);
	
	void delUser(int id);
}
