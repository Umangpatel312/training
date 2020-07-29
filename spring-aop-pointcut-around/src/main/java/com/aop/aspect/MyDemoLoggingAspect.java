package com.aop.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aop.demo.Account;

@Component
@Aspect
@Order(1)
public class MyDemoLoggingAspect { 
	private Logger myLogger=Logger.getLogger(MyDemoLoggingAspect.class.getName());
	@Around("execution(* com.aop.service.*.*(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		String method=theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("----> @after method of: "+method);
		
		long begin=System.currentTimeMillis();
		Object result=theProceedingJoinPoint.proceed();
		
		long end=System.currentTimeMillis();
		myLogger.info("traffic time: "+(end-begin));
		
		
		return result;
	}
	
	@After("execution(* com.aop.dao.AccountDAO.findAll(..))")
	public void afterFinallyFindAll(JoinPoint theJoinPoint) {
		String method=theJoinPoint.getSignature().toShortString();
		myLogger.info("----> @after method of: "+method);
		
		
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.aop.dao.AccountDAO.findAll(..))",
			throwing ="exc"
			)
	public void afterReturningFindAll(JoinPoint theJoinPoint,Throwable exc) {
		String method=theJoinPoint.getSignature().toShortString();
		myLogger.info("----> executing after method of: "+method);
		myLogger.info("@afterThrowing : "+exc);
		
	}
	
	@AfterReturning(
			pointcut = "execution(* com.aop.dao.AccountDAO.findAll(..))",
			returning = "result"
			)
	public void afterReturningFindAll(JoinPoint theJoinPoint,List<Account> result) {
		String method=theJoinPoint.getSignature().toShortString();
		myLogger.info("----> executing after method of: "+method);
		myLogger.info("result: "+result);
		if(!result.isEmpty()) {
			result.get(0).setName("Duck Daffy");
		}
	}
	
	
	@Before("com.aop.aspect.PointCutDeclaredGetterSetter.forDaoPackageNoGetterSetter()")/*apply on package inside any class and any method*/
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		//myLogger.info("\n\n");
		myLogger.info("\n----------------hey hey listen the voice of aspect--------");
		myLogger.info("method: "+theJoinPoint.getSignature());

		Object[] tempArg=theJoinPoint.getArgs();
		for(Object temp: tempArg) {
			
			myLogger.info(temp.toString());
			if(temp instanceof Account) {
				Account tempAccount=(Account)temp;
				myLogger.info("name: "+tempAccount.getName());
				myLogger.info("accountNumber: "+tempAccount.getAccountNumber());
			}
		}
	}
	
	
	
	
}
