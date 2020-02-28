package com.yzh.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yzh.App;
import com.yzh.dao.UsersRepositoryCRUD;
import com.yzh.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class UsersRepositroyCRUD {

	@Resource
	private UsersRepositoryCRUD usersRepositoryCRUD;
	
	/**
	 * CrudRepository save 测试
	 */
	@Test
	public void testSave(){
		Users users = new Users();
		users.setAddress("Eg");
		users.setAge(24);
		users.setName("Admin");
		this.usersRepositoryCRUD.save(users);
	}
	
	/**
	 * CrudRepository save 更新 测试
	 * save 既有保存也有更新
	 * 		底层先去判断是不是有这个实体，有则更新无则保存。
	 */
	@Test
	public void testUpdate(){
		Users users = new Users();
		users.setId(5);
		users.setAddress("Fg");
		users.setAge(24);
		users.setName("Admin");
		this.usersRepositoryCRUD.save(users);
	}
	
	/**
	 * 查询一个 ById
	 */
	@Test
	public void testFindOne(){
		Users user = this.usersRepositoryCRUD.findOne(4);
		System.out.println(user);
	}
	
	/**
	 * 查询所有
	 */
	@Test
	public void testFindAll(){
		Iterable<Users> users = this.usersRepositoryCRUD.findAll();
		for (Users user : users) {
			System.out.println(user);
		}
	}
	
	/**
	 * 删除
	 * 底层默认开启事务
	 */
	@Test
	public void testDelete(){
		this.usersRepositoryCRUD.delete(4);;
	}
}
