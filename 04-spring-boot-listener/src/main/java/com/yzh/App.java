package com.yzh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.yzh.filter.SecondFilter;
import com.yzh.listener.SecondListener;

@SpringBootApplication
@ServletComponentScan
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	/**
	 * 注册filter
	 * @return
	 */
	@Bean
	public FilterRegistrationBean getFilterRegistrationBean(){
		FilterRegistrationBean bean = new FilterRegistrationBean(
										new SecondFilter());
		bean.addUrlPatterns("/second");
		return bean;
	}
	
	/**
	 * 注册listener
	 * 
	 * 组件扫描注解 慢于 app内部方法扫描
	 * @return
	 */
	@Bean
	public ServletListenerRegistrationBean<SecondListener> getServletListenerRegistrationBean(){
		ServletListenerRegistrationBean<SecondListener> bean = new ServletListenerRegistrationBean<SecondListener>(new SecondListener());
		return bean;
	}
}
