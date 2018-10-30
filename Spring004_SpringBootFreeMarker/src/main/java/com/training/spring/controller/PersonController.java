package com.training.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.spring.form.PersonForm;
import com.training.spring.model.PersonModel;

@Controller
public class PersonController {
	private static List<PersonModel> persons = new ArrayList<>();

	static {
		persons.add(new PersonModel("11", "22"));
		persons.add(new PersonModel("33", "44"));
	}

	@Value("${welcome.message}")
	private String welcome;

	@Value("${error.message}")
	private String error;

	@RequestMapping(value = { "/", "index" }, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("message", welcome);
		return "index";
	}

	@RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
	public String personList(Model model) {
		model.addAttribute("persons", persons);
		return "personList";
	}

	@RequestMapping(value = { "/addPerson" }, method = RequestMethod.GET)
	public String addPersonForm(Model model) {
		PersonForm personForm = new PersonForm();
		model.addAttribute("personForm", personForm);
		return "addPerson";
	}

	@RequestMapping(value = { "/addPerson" }, method = RequestMethod.POST)
	public String addPersonSave(Model model, @ModelAttribute("personForm") PersonForm personForm) {
		String firstName = personForm.getFirstName();
		String lastName = personForm.getLastName();
		if (firstName != null && firstName.length() > 0 //
				&& lastName != null && lastName.length() > 0) {
			PersonModel newPerson = new PersonModel(firstName, lastName);
			persons.add(newPerson);

			return "redirect:/personList";
		}
        String error = "First Name & Last Name is required!";
        model.addAttribute("error", error);
        return "addPerson";
	}

}
