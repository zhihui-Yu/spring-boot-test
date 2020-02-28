package com.yzh.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yzh.App;
import com.yzh.pojo.Users;
import com.yzh.service.UsersService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class UserServiceTest {
	
	@Autowired
	private UsersService usersService;
	
	/**
	 * 在业务层的方法上面加入@Cacheable(value="users",key="#id")
	 * value: 所采用的策咯
	 * key: 以什么为标准， 如#id 就是id 一样的就直接从缓存中取
	 */
	@Test
	public void testFindUserById(){
		System.out.println(this.usersService.findUserById(1).toString());
		System.out.println(this.usersService.findUserById(1).toString());
	}
	
	@Test
	public void testFindUserByPage() {
		
		Pageable pageable = new PageRequest(0,2);
		
		System.out.println(this.usersService.findUserByPage(pageable).getTotalElements());
		
		System.out.println(this.usersService.findUserByPage(pageable).getTotalElements());
		
		pageable = new PageRequest(1,1);
		System.out.println(this.usersService.findUserByPage(pageable).getTotalElements());
		
	}
	
	/**
	 * 清除缓存测试
	 */
	@Test
	public void testFindUserAll(){
		
		System.out.println(this.usersService.findUserAll().size());
		
		Users u = new Users();
		u.setName("奇拿");
		u.setAddress("建宁");
		u.setAge(25);
		this.usersService.saveUsers(u);
		
		System.out.println(this.usersService.findUserAll().size());
	}
}
