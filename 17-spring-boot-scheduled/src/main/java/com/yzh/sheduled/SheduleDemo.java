package com.yzh.sheduled;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
//在App.class 中要@EnableScheduling
@Component
public class SheduleDemo {
	// 秒 分 时 日 月 星期 年  年可以省略  
	@Scheduled(cron="0/2 * * * * ?")
	public void sheduleMethod(){
		System.out.println(new Date());
	}
}
