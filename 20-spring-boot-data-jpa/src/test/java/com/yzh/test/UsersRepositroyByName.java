package com.yzh.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yzh.App;
import com.yzh.dao.UsersRepositoryByName;
import com.yzh.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class UsersRepositroyByName {

	@Resource
	private UsersRepositoryByName usersRepositoryByName;
	
	/**
	 * Repository ---- 方法名称命名测试
	 */
	@Test
	public void testFindByName(){
		int x = this.usersRepositoryByName.findByName("张三").size();
		System.out.println(x);
	}
	
	/**
	 * Repository ---- 方法名称命名测试 and
	 */
	@Test
	public void testFindByNameAndAge(){
		List<Users> list = this.usersRepositoryByName.findByNameAndAge("张三",21);
		for (Users user : list) {
			System.out.println(user);
		}
	}
	/**
	 * Like
	 */
	@Test
	public void testFindByNameLike(){
		List<Users> list = this.usersRepositoryByName.findByNameLike("张%");
		for (Users user : list) {
			System.out.println(user);
		}
	}
}
