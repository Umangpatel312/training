package com.aop.demo;

public class Account {
	private int accountNumber;
	private String name; 
	
	Account(){
		
	}
	public Account(int accountNumber, String name) {
		this.accountNumber = accountNumber;
		this.name = name;
	}


	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + "]";
	}
	
}
