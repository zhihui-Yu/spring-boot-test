package com.yzh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.yzh.servlet.SecondServlet;
/**
 * app文件必须在controller 的上级包或者同包下才可以  不能再controller包的子包或者同级包
 * @author listener
 *
 */

@SpringBootApplication
@ServletComponentScan
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Bean
	public ServletRegistrationBean getServletRegistrationBean(){
		ServletRegistrationBean bean = new ServletRegistrationBean(
										new SecondServlet());
		bean.addUrlMappings("/second");
		return bean;
	}
}
