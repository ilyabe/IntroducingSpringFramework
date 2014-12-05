package com.apress.isf.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Application {

	@Bean
	MessageService helloWorldMessageService() {
		return new HelloWorldMessage();
	}
	
	public static void main(String[] args) {
		// Initialize application context with configuration in Application.class
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		
		// Have context provide the MessageService dependency
		MessageService service = context.getBean(MessageService.class);
		
		// Test that a MessageService object was injected properly
		System.out.println(service.getMessage());
	}
}
