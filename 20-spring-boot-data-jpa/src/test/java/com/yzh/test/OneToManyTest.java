package com.yzh.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yzh.App;
import com.yzh.dao.UsersRepository;
import com.yzh.pojo.Roles;
import com.yzh.pojo.Users;

/**
 * 一对多关联测试
 * @author listener
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class OneToManyTest {

	@Resource
	private UsersRepository usersRepository;
	
	/**
	 * 一对多关联关系的添加
	 */
	@Test
	public void testSave() {
		//创建一个用户
		Users user = new Users();
		user.setName("小明");
		user.setAge(21);
		user.setAddress("");
		
		//创建一个角色
		Roles roles = new Roles();
		roles.setRolename("管理员");
		
		//关联
		//roles.getUsers().add(user);
		user.setRoles(roles);
		
		//保存
		this.usersRepository.save(user);
	}
	
	/**
	 * 一对多关联关系的查询
	 */
	@Test
	public void testFind(){
		Users user = this.usersRepository.findOne(7);
		System.out.println(user);
		
		Roles roles = user.getRoles();
		System.out.println(roles.getRolename());
	}
}
