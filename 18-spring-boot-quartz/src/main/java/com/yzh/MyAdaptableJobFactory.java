package com.yzh;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

@Component("myAdaptableJobFactory")
public class MyAdaptableJobFactory extends AdaptableJobFactory{
	//AutowireCapableBeanFactory 可以将一个对象添加到 SpringIOC 容器中， 并且完成该对象注入
	@Autowired
	private AutowireCapableBeanFactory autowireCapableBeanFactory;
	
	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
		Object obj = super.createJobInstance(bundle);
		//将 obj 对象添加 Spring IOC 容器中，并完成注入
		this.autowireCapableBeanFactory.autowireBean(obj);
		return obj;
	}
	
}
