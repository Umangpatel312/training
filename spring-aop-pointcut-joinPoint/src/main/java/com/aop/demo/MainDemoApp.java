package com.aop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.dao.AccountDAO;
import com.aop.dao.MembershipDAO;

public class MainDemoApp {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context=new 
				AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
		Account account=new Account();
		account.setName("mary");
		account.setAccountNumber(123456);
		
		accountDAO.addAccount(account,true);
		
		accountDAO.doWork();
		
		accountDAO.setAccount("account");
		accountDAO.getAccount();
		accountDAO.setRecordName("name");
		accountDAO.getRecordName();
		
		//create object of MemberShipDAO 
		MembershipDAO membershipDAO=context.getBean(MembershipDAO.class);
		membershipDAO.addSilyAccount();
		
		membershipDAO.sillyWork();
		
		
		context.close();
		
	}
}
