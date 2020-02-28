package com.yzh.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.yzh.service.UserService;

/**
 * 创建当前类时候，并没用用到spring，所以不会扫描类下的注解
 * @author listener
 *
 */
public class QuartzDemo implements Job{
	
	@Autowired
	private UserService userService;
	
	/**
	 * 任务被触发时所执行的方法
	 */
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("Execute ----"+new Date());
		userService.save();
	}
}
