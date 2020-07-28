package com.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoLoggingAspect { 
	
	//@Before("execution(public void addAccount())")
		//@Before("execution(public void com.aop.dao.AccountDAO.addAccount())")
		/*above method call with same declarative-type match*/
//		@Before("execution(public void add*())")/*it is call start method name with add*/
		
//		@Before("execution(void addAccount())")
		/*specifier is optional and match with return type is void*/
		//@Before("execution(* addAccount())")
		
//		@Before("execution(* addAccount(com.aop.demo.Account, ..))")
		/*if I do not provide fully package of class then it will generate error so
		 * take care
		 * */
//		@Before("execution(* add*(..))")
//		@Before("execution(* com.aop.dao.*.*(..))")/*apply on package inside any class and any method*/
		
		@Before("execution(* com.aop.dao.*.*(..))")/*apply on package inside any class and any method*/
		public void beforeAddAccountAdvice() {
			System.out.println("\n\n");
			System.out.println("\n----------------hey hey listen the voice of aspect--------");
		}
	
}
