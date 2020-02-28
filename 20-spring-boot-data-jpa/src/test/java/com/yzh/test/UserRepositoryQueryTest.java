package com.yzh.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yzh.App;
import com.yzh.dao.UsersRepositoryQueryAnnotation;
import com.yzh.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class UserRepositoryQueryTest {
	
	@Autowired
	private UsersRepositoryQueryAnnotation usersRepository;
	
	/**
	 * @Query测试
	 */
	@Test
	public void testQueryByNameHQL() {
		List<Users> list = this.usersRepository.queryByNameUserHQL("张三");
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	/**
	 * SQL @Query
	 */
	@Test
	public void testQueryByNameSQL() {
		List<Users> list = this.usersRepository.queryByNameUserSQL("张三");
		for (Users users : list) {
			System.out.println(users);
		}
	}
	
	/**
	 * SQL update @Query
	 * 不加rollback自动回滚 因为是与@test一起用
	 */
	@Test
	public void testUpdateUsersNameById() {
		this.usersRepository.updateUsersNameById("张三", 2);
	}
}
