package com.aop.dao;

import org.springframework.stereotype.Component;

import com.aop.demo.Account;

@Component
public class AccountDAO {
	public void addAccount(Account account,boolean vipFlag) {
		System.out.println(getClass()+" adding to DB user account");
	} 
	
	public boolean doWork() {
		System.out.println(getClass()+" work()");
		return false;
	}
}
