package com.aop.dao;

import org.springframework.stereotype.Component;

@Component 
public class MembershipDAO {
	public boolean addSilyAccount() {
		System.out.println(getClass()+" account added for Membership...");
		return false;
	}
	public void sillyWork() {
		System.out.println(getClass()+" sillyWord()...");
	}
}
