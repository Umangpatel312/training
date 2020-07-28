package com.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class MyDemoLoggingAspect { 
	
	
	
	@Before("com.aop.aspect.PointCutDeclaredGetterSetter.forDaoPackageNoGetterSetter()")/*apply on package inside any class and any method*/
	public void beforeAddAccountAdvice() {
		//System.out.println("\n\n");
		System.out.println("\n----------------hey hey listen the voice of aspect--------");
	}
	
	
	
	
}
