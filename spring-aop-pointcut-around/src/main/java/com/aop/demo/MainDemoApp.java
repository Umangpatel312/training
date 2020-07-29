package com.aop.demo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.dao.AccountDAO;
import com.aop.dao.MembershipDAO;
import com.aop.service.FortuneService;

public class MainDemoApp {
	private static Logger myLogger=Logger.getLogger(MainDemoApp.class.getName()); 
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context=new 
				AnnotationConfigApplicationContext(DemoConfig.class);
		FortuneService fortuneService=context.getBean("fortuneService",FortuneService.class);
		
		myLogger.info("calling service for fortune service");
		myLogger.info(fortuneService.getFortuneService());
		context.close();
		
	}
}
