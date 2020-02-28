package com.yzh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yzh.pojo.Users;

/**
 * 参数一： T 当前需要隐射的实体
 * 参数二：ID 当前需要需要的实体的主键类型
 * @author listener
 *
 */
public interface UsersRepository extends JpaRepository<Users, Integer>{

}
