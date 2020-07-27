package com.config;

import javax.servlet.ServletContext; 
import javax.servlet.ServletException;

import org.springframework.context.ApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebApplicationContextConfig.class};
	}
	
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
}

//public class MyWebApplicationInitializer implements WebApplicationInitializer {
//
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//
//		var ctx = new AnnotationConfigWebApplicationContext();
//		
//		ctx.register(WebConfig.class);
//		ctx.setServletContext(servletContext);
//		
//		var servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
//		servlet.setLoadOnStartup(1);
//		servlet.addMapping("/");
//	}
//}
