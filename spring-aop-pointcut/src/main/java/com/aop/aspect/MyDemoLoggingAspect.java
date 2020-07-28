package com.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoLoggingAspect { 
	
	@Pointcut("execution(* com.aop.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.aop.dao.*.get*(..))")
	private void getter() {}
	
	@Pointcut("execution(* com.aop.dao.*.set*(..))")
	private void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()")/*apply on package inside any class and any method*/
	public void beforeAddAccountAdvice() {
		//System.out.println("\n\n");
		System.out.println("\n----------------hey hey listen the voice of aspect--------");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performAnalysis() {
		System.out.println("\n----------------hey hey this is  preanalysis--------");
	}
	
	
}
