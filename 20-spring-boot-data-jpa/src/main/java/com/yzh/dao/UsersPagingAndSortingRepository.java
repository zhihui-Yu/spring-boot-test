package com.yzh.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.yzh.pojo.Users;

/**
 * 有分页效果
 * @author listener
 *
 */
public interface UsersPagingAndSortingRepository extends PagingAndSortingRepository<Users, Integer>{

}
