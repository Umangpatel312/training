package com.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCutDeclaredGetterSetter {
	@Pointcut("execution(* com.aop.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* com.aop.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* com.aop.dao.*.set*(..))")
	public void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
}
