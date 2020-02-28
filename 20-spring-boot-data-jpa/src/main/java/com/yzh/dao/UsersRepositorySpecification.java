package com.yzh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yzh.pojo.Users;

public interface UsersRepositorySpecification extends JpaRepository<Users, Integer>,JpaSpecificationExecutor<Users>{

}
