package com.training.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BootStrapController {
	@RequestMapping("/")
	public String bootStrap(Model model) {
		return "index";
	}
}
