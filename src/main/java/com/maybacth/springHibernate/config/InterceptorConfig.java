package com.maybacth.springHibernate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.maybacth.springHibernate.inerceptors.CustomInterceptor;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class InterceptorConfig extends WebMvcConfigurerAdapter {
	
	
	@Autowired
	private CustomInterceptor customInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		InterceptorRegistration interceptorRegistry = registry.addInterceptor(customInterceptor);
		interceptorRegistry.addPathPatterns("/v1/api/*");
		
	
	}
	
	

}
