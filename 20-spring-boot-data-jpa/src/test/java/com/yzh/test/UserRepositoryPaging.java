package com.yzh.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yzh.App;
import com.yzh.dao.UsersPagingAndSortingRepository;
import com.yzh.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class UserRepositoryPaging {
	
	@Autowired
	private UsersPagingAndSortingRepository usersRepository;

	/**
	 * 排序
	 */
	@Test
	public void testSort() {
		//order 定义排序规则
		Order order = new Order(Direction.DESC,"id");
		Sort sort = new Sort(order);
		//sort 封装排序规则
		Iterable<Users> users = this.usersRepository.findAll(sort);
		for (Users user : users) {
			System.out.println(user);
		}
	}
	
	/**
	 * 分页
	 */
	@Test
	public void testPaging() {
		//pageable 封装分页参数，当前页,每页显示的条数  当前页从0开始
		Pageable pageable = new PageRequest(0, 2);
		
		Page<Users> users = this.usersRepository.findAll(pageable);
		for (Users user : users) {
			System.out.println(user);
		}
		
		System.out.println("总条数"+users.getTotalElements());
		System.out.println("总页数"+users.getTotalPages());
	}
	
	/**
	 * 分页+排序
	 */
	@Test
	public void testPagingAndSort() {
		//pageable 封装分页参数，当前页,每页显示的条数  当前页从0开始
		Order order = new Order(Direction.DESC,"id");
		Sort sort = new Sort(order);
		Pageable pageable = new PageRequest(0, 2, sort);
		Page<Users> users = this.usersRepository.findAll(pageable);
		for (Users user : users) {
			System.out.println(user);
		}
	}
	
}
