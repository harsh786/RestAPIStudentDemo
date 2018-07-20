package com.harsh.student.RestAPIStudentDemo;

import org.springframework.boot.SpringApplication;
import javax.servlet.Filter;
import javax.ws.rs.core.Application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
@SpringBootApplication
@EnableTransactionManagement
public class RestApiStudentDemoApplication extends SpringBootServletInitializer {
	private static Class applicationClass = Application.class;
	public static void main(String[] arg) {
		SpringApplication.run(RestApiStudentDemoApplication.class, arg);
		int a=6;
	}
	
	 @Bean
	    public Filter filter(){
	        ShallowEtagHeaderFilter filter=new ShallowEtagHeaderFilter();
	        return filter;
	    }
	 
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(applicationClass);
	    }
}

