package com.yzh;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.yzh.quartz.QuartzDemo;

@Configuration
public class QuartzConfig {

	/**
	 * 1 创建job对象
	 * @return
	 */
	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean() {
		JobDetailFactoryBean  factory = new JobDetailFactoryBean();
		//关联自己的Job类
		factory.setJobClass(QuartzDemo.class);
		return factory;
	}
	/**
	 * 2 创建trigger对象
	 * 
	 * @param jobDetailFactoryBean
	 * @return
	 */
/*	@Bean
	public SimpleTriggerFactoryBean simpleTriggerFactoryBean(
			JobDetailFactoryBean jobDetailFactoryBean) {
		SimpleTriggerFactoryBean factory = new SimpleTriggerFactoryBean();
		//关联JobDetail对象
		factory.setJobDetail(jobDetailFactoryBean.getObject());
		//该参数表示一个执行的毫秒数
		factory.setRepeatInterval(2000);
		//重复次数
		factory.setRepeatCount(5);
		return factory;
	}*/
	
	/**
	 * 3 创建scheduler对象
	 * @param simpleTriggerFactoryBean
	 * @return
	 */
/*	@Bean
	public SchedulerFactoryBean sheduleFactoryBean(
			SimpleTriggerFactoryBean simpleTriggerFactoryBean) {
		SchedulerFactoryBean factory = new SchedulerFactoryBean();
		//关联trigger
		factory.setTriggers(simpleTriggerFactoryBean.getObject());
		return factory;
	}
	*/
	
	//另一种 方法
	/**
	 * Cron Trigger
	 * @param jobDetailFactoryBean
	 * @return
	 */
	@Bean
	public CronTriggerFactoryBean CronTriggerFactoryBean(
			JobDetailFactoryBean jobDetailFactoryBean) {
		CronTriggerFactoryBean factory = new CronTriggerFactoryBean();
		//关联JobDetail对象
		factory.setJobDetail(jobDetailFactoryBean.getObject());
		//设置触发时间
		factory.setCronExpression("0/3 * * * * ?");
		return factory;
	}
	
	@Bean
	public SchedulerFactoryBean sheduleFactoryBean(
			CronTriggerFactoryBean cronTriggerFactoryBean
			,MyAdaptableJobFactory myAdaptableJobFactory) {
		SchedulerFactoryBean factory = new SchedulerFactoryBean();
		//关联trigger
		factory.setTriggers(cronTriggerFactoryBean.getObject());
		factory.setJobFactory(myAdaptableJobFactory);
		return factory;
	}
}
