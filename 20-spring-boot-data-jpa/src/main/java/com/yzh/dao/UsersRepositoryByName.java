package com.yzh.dao;


import java.util.List;

import org.springframework.data.repository.Repository;

import com.yzh.pojo.Users;

public interface UsersRepositoryByName extends Repository<Users,Integer>{
	//名称必须驼峰式，findBy(关键字)+属性名称(首字母大写)+查询条件(首字母大写)
	List<Users> findByName(String name);
	
	List<Users> findByNameAndAge(String name, Integer age);
	
	List<Users> findByNameLike(String name);
}
