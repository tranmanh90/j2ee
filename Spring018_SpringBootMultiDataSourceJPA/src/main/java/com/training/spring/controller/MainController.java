package com.training.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.spring.dao.AdvertiserDAO;
import com.training.spring.dao.PublisherDAO;
import com.training.spring.entity1.Publisher;
import com.training.spring.entity2.Advertiser;

@Controller
public class MainController {

	@Autowired
	private PublisherDAO publisherDAO;

	@Autowired
	private AdvertiserDAO advertiserDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(Model model) {

		List<Advertiser> advertisers = advertiserDAO.listAdvertisers();
		List<Publisher> publishers = publisherDAO.listPublishers();

		model.addAttribute("advertisers", advertisers);
		model.addAttribute("publishers", publishers);

		return "home";
	}
}