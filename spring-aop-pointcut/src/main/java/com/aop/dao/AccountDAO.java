package com.aop.dao;

import org.springframework.stereotype.Component;

import com.aop.demo.Account;

@Component
public class AccountDAO {
	private String account;
	private String recordName;
	
	public void addAccount(Account account,boolean vipFlag) {
		System.out.println(getClass()+" adding to DB user account");
	} 
	
	public boolean doWork() {
		System.out.println(getClass()+" work()");
		return false;
	}

	public String getAccount() {
		System.out.println(getClass()+" of getter");
		return account;
	}

	public void setAccount(String account) {
		System.out.println(getClass()+" of setter");
		this.account = account;
	}

	public String getRecordName() {
		System.out.println(getClass()+" of getter");
		return recordName;
	}

	public void setRecordName(String recordName) {
		this.recordName = recordName;
		System.out.println(getClass()+" of setter");
	}
	
}
