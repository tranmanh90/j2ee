package com.book.store.tm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TMWelcome {
	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "Welcome to Share tutorial web service !!!";
	}
}
