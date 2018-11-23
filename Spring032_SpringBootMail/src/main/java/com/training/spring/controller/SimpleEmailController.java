package com.training.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.spring.config.MailConfig;

@Controller
public class SimpleEmailController {
	@Autowired
	private JavaMailSender mailSender;
	
	@ResponseBody
	@RequestMapping("/sendSimpleEmail")
	public String sendSimpleEmail() {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(MailConfig.FRIEND_EMAIL);
		mailMessage.setSubject("Test mail");
		mailMessage.setText("HAHAHAHAHAHA");
		
		this.mailSender.send(mailMessage);
		
		return "Email Sent!";
	}
}
