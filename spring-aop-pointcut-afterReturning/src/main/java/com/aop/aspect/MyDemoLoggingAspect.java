package com.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aop.demo.Account;

@Component
@Aspect
@Order(1)
public class MyDemoLoggingAspect { 
	
	
	
	@Before("com.aop.aspect.PointCutDeclaredGetterSetter.forDaoPackageNoGetterSetter()")/*apply on package inside any class and any method*/
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		//System.out.println("\n\n");
		System.out.println("\n----------------hey hey listen the voice of aspect--------");
		System.out.println("method: "+theJoinPoint.getSignature());

		Object[] tempArg=theJoinPoint.getArgs();
		for(Object temp: tempArg) {
			
			System.out.println(temp);
			if(temp instanceof Account) {
				Account tempAccount=(Account)temp;
				System.out.println("name: "+tempAccount.getName());
				System.out.println("accountNumber: "+tempAccount.getAccountNumber());
			}
		}
	}
	
	
	
	
}
