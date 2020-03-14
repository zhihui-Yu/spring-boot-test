package com.yzh.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

	/** 
	 * 1.创建 JedisPoolConfig 对象。在该对象中完成一些链接池配置 
	 * @ConfigurationProperties 在返回对象后添加内容
	 */
	@Bean
	@ConfigurationProperties(prefix="spring.redis.pool")
	JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig config = new JedisPoolConfig();

		// 最大空闲数
		//config.setMaxIdle(10);

		// 最小空闲数
		//config.setMinIdle(5);

		// 最大链接数
		//config.setMaxTotal(20);

		return config;
	}

	/**
	 * 创建JedisConnectFactory 配置 redis连接信息
	 * @param config
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix="spring.redis")
	public JedisConnectionFactory jedisConnectionFactory(
			JedisPoolConfig config) {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		//关联链接池的配置对象 
		factory.setPoolConfig(config); 
		//配置链接 Redis 的信息 
		//主机地址
		//factory.setHostName("192.168.1.128"); 
		//端口 
		//factory.setPort(6379);
		return factory;
	}
	
	/**
	 * 创建 RedisTemplate 用户执行redis操作
	 * @param factory
	 * @return
	 */
	@Bean
	public RedisTemplate<String, Object> redisTemplate(
			JedisConnectionFactory factory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		
		//关联工厂
		template.setConnectionFactory(factory);
		
		//设置key的序列号器
		template.setKeySerializer(new StringRedisSerializer());
		
		//设置value的序列化器
		template.setValueSerializer(new StringRedisSerializer());
		return template;
	}
}
