package com.training.spring.tm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TMWelcome {
	@RequestMapping(value = "/haha", method = RequestMethod.GET)
	public String welcome(Model model) {
		return "index";
	}
}
