package com.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.aop.demo.Account;

@Component
public class AccountDAO {
	private String account;
	private String recordName;
	
public List<Account> findAll(boolean b){
		if(b==true) {
			throw new RuntimeException("generated error..");
		}
		List<Account> list=new ArrayList<>();
		Account account1=new Account(12345,"Mary");
		Account account2=new Account(1233433,"john");
		Account account3=new Account(12345,"harry");
		
		list.add(account1);
		list.add(account2);
		list.add(account3);
		return list;
	}
	
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
