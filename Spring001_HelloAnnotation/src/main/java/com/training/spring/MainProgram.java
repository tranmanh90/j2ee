package com.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainProgram {

	public static void main(String[] args) {
		// Tạo ra một đối tượng ApplicationContext bằng cách đọc cấu hỉnh
		// trong class AppConfiguration
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println("----------");
		Language language = (Language)context.getBean("language");
		
		System.out.println("Bean Language: " + language);
		System.out.println("Call language.sayBye(): " + language.getBye());
		System.out.println("----------");
		
		GreetingService service = (GreetingService)context.getBean("greetingService");
		service.sayGreeting();
		System.out.println("----------");
		
		SpringComponent component = (SpringComponent)context.getBean("springComponent");
		component.showAppInfo();
	}

}
