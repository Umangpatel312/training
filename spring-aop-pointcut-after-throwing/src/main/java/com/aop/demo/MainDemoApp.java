package com.aop.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.dao.AccountDAO;
import com.aop.dao.MembershipDAO;

public class MainDemoApp {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context=new 
				AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
		List<Account> list=null;
		try {
			list=accountDAO.findAll(true);
		}
		catch(Exception e) {
			System.out.println("Main: "+e);
		}
		System.out.println("Main :after returning data:");
		System.out.println(list);
		
		
		context.close();
		
	}
}
