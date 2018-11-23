package com.training.spring.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	
	private static final String MY_EMAIL = "timbantinhvuto@gmail.com";
	private static final String MY_PASSWORD = "tranmanh90";
	public static final String FRIEND_EMAIL = "tranmanh.vn90@gmail.com";
	
	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		mailSenderImpl.setHost("smtp.gmail.com");
		mailSenderImpl.setPort(587);
		mailSenderImpl.setUsername(MY_EMAIL);
		mailSenderImpl.setPassword(MY_PASSWORD);
		
		Properties properties = mailSenderImpl.getJavaMailProperties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.debug", "true");
		
		return mailSenderImpl;
	}
}
