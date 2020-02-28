package com.yzh.test;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yzh.App;
import com.yzh.dao.UsersRepositorySpecification;
import com.yzh.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class UsersRepositroySpecification {

	@Resource
	private UsersRepositorySpecification usersRepositorySpecification;
	
	/**
	 * JpaSpecificationExecutor test
	 * 
	 * 单条件
	 */
	@Test
	public void test(){
		//封装查询条件
		Specification<Users> spec = new Specification<Users>() {
			/**
			 * predicate 封装单个查询条件
			 * 
			 * Root<Users> 查询对象的属性的封装
			 * CriteriaQuery<?> 封装执行的部分条件
			 * CriteriaBuilder 查询条件构造器，定义不同的查询条件
			 */
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// where name = '张三'
				/**
				 * 参数一 ：查询条件属性
				 * 参数二 ：条件的值
				 */
				Predicate pre = cb.equal(root.get("name"), "张三");
				return pre;
			}
		};
		
		List<Users> list = this.usersRepositorySpecification.findAll(spec);
		for (Users user : list) {
			System.out.println(user);
		}
		
	}
	
	/**
	 * JpaSpecificationExecutor test
	 * 
	 * 多条件
	 */
	@Test
	public void test2(){
		//封装查询条件
		Specification<Users> spec = new Specification<Users>() {
			/**
			 * predicate 封装单个查询条件
			 * 
			 * Root<Users> 查询对象的属性的封装
			 * CriteriaQuery<?> 封装执行的部分条件
			 * CriteriaBuilder 查询条件构造器，定义不同的查询条件
			 */
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// where name = '张三' and age = 20
				/**
				 * 参数一 ：查询条件属性
				 * 参数二 ：条件的值
				 */
				/*List<Predicate> list = new ArrayList<>();
				list.add(cb.equal(root.get("name"), "张三"));
				list.add(cb.equal(root.get("age"), 20));

				Predicate[] arr = new Predicate[list.size()];
				return cb.and(list.toArray(arr));*/
				//方法二 直接传入 可变参数
				//return cb.and(cb.equal(root.get("name"), "张三"),cb.equal(root.get("age"), 20));
				
				//... or .... 
				//return cb.or(cb.equal(root.get("name"), "张三"),cb.equal(root.get("age"), 20));
				
				//有or 又有 and
				return cb.or(cb.and(cb.equal(root.get("name"), "张三"),cb.equal(root.get("age"), 20)),cb.equal(root.get("address"), ""));
			}
		};
		
		//排序
		Sort sort = new Sort( new Order(Direction.DESC,"id"));
		
		List<Users> list = this.usersRepositorySpecification.findAll(spec, sort);
		for (Users user : list) {
			System.out.println(user);
		}
		
	}
	
}
