package com.tobias.saul.shiro;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.apache.shiro.web.jaxrs.ShiroFeature;

// application mounted to /, all resource paths relative to
@ApplicationPath("/")
public class RestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(ShiroFeature.class); // register Apache Shiro's JAX-RS feature
		classes.add(SecureResource.class); 
		return classes;
		
	}
	
	

}
