package com.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
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
	
	@After("execution(* com.aop.dao.AccountDAO.findAll(..))")
	public void afterFinallyFindAll(JoinPoint theJoinPoint) {
		String method=theJoinPoint.getSignature().toShortString();
		System.out.println("----> @after method of: "+method);
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.aop.dao.AccountDAO.findAll(..))",
			throwing ="exc"
			)
	public void afterReturningFindAll(JoinPoint theJoinPoint,Throwable exc) {
		String method=theJoinPoint.getSignature().toShortString();
		System.out.println("----> executing after method of: "+method);
		System.out.println("@afterThrowing : "+exc);
		
	}
	
	@AfterReturning(
			pointcut = "execution(* com.aop.dao.AccountDAO.findAll(..))",
			returning = "result"
			)
	public void afterReturningFindAll(JoinPoint theJoinPoint,List<Account> result) {
		String method=theJoinPoint.getSignature().toShortString();
		System.out.println("----> executing after method of: "+method);
		System.out.println("result: "+result);
		if(!result.isEmpty()) {
			result.get(0).setName("Duck Daffy");
		}
	}
	
	
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
