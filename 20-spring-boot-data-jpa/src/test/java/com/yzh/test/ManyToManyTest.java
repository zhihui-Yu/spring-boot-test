package com.yzh.test;

import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yzh.App;
import com.yzh.dao.RolesRepository;
import com.yzh.pojo.Menu;
import com.yzh.pojo.Roles;

/**
 * 多对多关联测试
 * @author listener
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class ManyToManyTest {

	@Resource
	private RolesRepository rolesRepository;
	
	/**
	 * 多对多关联关系的添加
	 */
	@Test
	public void testSave() {
		//创建一个角色
		Roles r = new Roles();
		r.setRolename("经理");
		
		//创建一个菜单
		Menu menu = new Menu();
		menu.setMenuname("xxx管理系统");
		menu.setFatherid(0);
		
		Menu menu2 = new Menu();
		menu2.setMenuname("项目管理");
		menu2.setFatherid(1);
		
		//关联
		r.getMenu().add(menu);
		r.getMenu().add(menu2);
		
		menu.getRoles().add(r);
		menu.getRoles().add(r);
		
		//保存
		this.rolesRepository.save(r);
	}
	
	/**
	 * 多对多关联关系的查询
	 */
	@Test
	public void testFind(){
		Roles roles = this.rolesRepository.findOne(2);
		System.out.println(roles.getRolename());
		Set<Menu> menu = roles.getMenu();
		for (Menu menu2 : menu) {
			System.out.println(menu2);
		}
	}
}
