package com.yzh.mapper;

import java.util.List;

import com.yzh.pojo.User;

public interface UserMapper {
	
	int insUser(User user);
	
	List<User> selectUserAll(); 
	
	User selectUserById(Integer id);
	
	void updateUser(User user); 
	
	void delUser(int id);
}
