package com.yzh.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yzh.App;
import com.yzh.dao.UsersRepository;
import com.yzh.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class UsersRepositoryTest {
	//JpaRepository 继承 PagingAndSortingRepository
	@Resource
	private UsersRepository usersRepository;
	
	@Test
	public void testSave() {
		Users user = new Users();
		user.setAddress("福建省");
		user.setAge(20);
		user.setName("张三");
		this.usersRepository.save(user);
	}
}
