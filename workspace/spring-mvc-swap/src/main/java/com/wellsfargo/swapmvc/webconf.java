package com.wellsfargo.swapmvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class webconf implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(SwapBeanConf.class);
		context.setServletContext(servletContext);
		
		
		ServletRegistration.Dynamic servletReg = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
		servletReg.setLoadOnStartup(1);
		servletReg.addMapping("/");
		
	}

}