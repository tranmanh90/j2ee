package com.training.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.spring.model.Person;

@Controller
public class PersonController {
	private static List<Person> persons = new ArrayList<>();

	static {
		persons.add(new Person("hehe", "haha"));
		persons.add(new Person("haha", "hehe"));
	}

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("message", "Hello Spring Boot + JSP");
		return "index";
	}

	@RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
	public String viewPersonList(Model model) {
		model.addAttribute("persons", persons);
		return "personList";
	}
}
