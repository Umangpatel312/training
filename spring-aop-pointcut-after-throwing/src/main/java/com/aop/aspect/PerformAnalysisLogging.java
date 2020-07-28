package com.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class PerformAnalysisLogging {
	@Before("com.aop.aspect.PointCutDeclaredGetterSetter.forDaoPackageNoGetterSetter()")
	public void performAnalysis() {
		System.out.println("\n----------------hey hey this is  preanalysis--------");
	}
}
