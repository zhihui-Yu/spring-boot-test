package com.yzh.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.yzh.pojo.Users;

public interface UsersService {
	
	List<Users> findUserAll();
	
	Users findUserById(Integer id);
	
	Page<Users> findUserByPage(Pageable pageable);
	
	void saveUsers(Users users);
}
