package com.aop.service;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Component;

@Component
public class FortuneService {
	public String getFortuneService() {
		try {
			TimeUnit.SECONDS.sleep(5);
		}
		catch(InterruptedException e) {
			System.out.println(e.toString());
		}
		return "heavy traffic is here of fortune service";
	}
	public String getFortuneService(boolean b) {
		// TODO Auto-generated method stub
		if(b) {
			throw new RuntimeException("due to heavy load");
		}
		return "heavy traffic";
	}
}
