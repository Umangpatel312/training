package com.aop.service;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component
public class FortuneService {
	private Logger myLogger=Logger.getLogger(FortuneService.class.getName());
 	public String getFortuneService() {
		try {
			TimeUnit.SECONDS.sleep(5);
		}
		catch(InterruptedException e) {
			myLogger.info(e.toString());
		}
		return "heavy traffic is here";
	}
}
