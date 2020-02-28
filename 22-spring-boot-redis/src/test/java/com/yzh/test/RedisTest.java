package com.yzh.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yzh.App;
import com.yzh.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class RedisTest {
	
	@Resource
	private RedisTemplate<String,Object> redisTemplate;
	
	/**
	 * 添加一个字符串
	 */
	@Test
	public void testSet(){
		this.redisTemplate.opsForValue().set("key1", "new name");
	}
	
	/**
	 * 获取一个字符串
	 */
	@Test
	public void testGet(){
		String value = (String)this.redisTemplate.opsForValue().get("key1");
		System.out.println(value);
	}
	
	/**
	 * 利用jdk序列化存入一个user对象
	 * 对象需要序列化
	 */
	@Test
	public void testSetUser(){
		User user = new User("张三","234",23);
		
		//重新设置序列化器
		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		
		this.redisTemplate.opsForValue().set("user", user);
	}
	
	/**
	 * 利用jdk序列化取一个user对象
	 */
	@Test
	public void testGetUser(){
		
		//取值之前要做存值对应的操作
		//重新设置序列化器
		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		
		User user = (User)this.redisTemplate.opsForValue().get("user");
		
		System.out.println(user);
	}
	
	/**
	 * 利用Json序列化存入一个user对象
	 */
	@Test
	public void testSetUserByJson(){
		User user = new User("张三","234",23);
		
		//重新设置序列化器
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
		
		this.redisTemplate.opsForValue().set("user", user);
	}
	
	/**
	 * 利用Json序列化取一个user对象
	 */
	@Test
	public void testGetUserByJson(){
		
		//重新设置序列化器
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
		
		User user = (User)this.redisTemplate.opsForValue().get("user");
		
		System.out.println(user);
	}
}
