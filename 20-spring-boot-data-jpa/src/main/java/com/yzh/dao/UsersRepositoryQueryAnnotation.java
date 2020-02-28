package com.yzh.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.yzh.pojo.Users;

/**
 *  Query注解使用
 * @author listener
 *
 */
public interface UsersRepositoryQueryAnnotation extends Repository<Users, Integer> {

	@Query("from Users where name = ?")
	List<Users> queryByNameUserHQL(String name);
	
	@Query(value="select * from Users where name = ?",nativeQuery=true)
	List<Users> queryByNameUserSQL(String name);
	
	@Transactional
	@Modifying
	@Query("update Users set name = ? where id = ?")
	void updateUsersNameById(String name,Integer id);
}
