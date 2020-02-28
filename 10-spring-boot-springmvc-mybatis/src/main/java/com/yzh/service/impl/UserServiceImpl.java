package com.yzh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yzh.mapper.UserMapper;
import com.yzh.pojo.User;
import com.yzh.service.UserService;

@Service("UserService")
@Transactional	
public class UserServiceImpl implements UserService {

	@Resource	
	private UserMapper userMapper;
	
	@Override
	public int addUser(User user) {
		return this.userMapper.insUser(user);
	}

	@Override
	public List<User> findUserAll() {
		return this.userMapper.selectUserAll();
	}

	@Override
	public User findUserById(Integer id) {
		return this.userMapper.selectUserById(id);
	}

	@Override
	public void updateUser(User user) {
		this.userMapper.updateUser(user);
	}

	@Override
	public void delUser(int id) {
		this.userMapper.delUser(id);
	}

}
