package com.capella.searchapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capella.searchapp.controller.model.Country;
import com.capella.searchapp.controller.service.CountryRepository;
import com.capella.searchapp.controller.service.SessionService;
import com.capella.searchapp.mongodb.model.Countries;
import com.capella.searchapp.mongodb.services.CountriesService;

/**
 * Sample controller for going to the home page with a message
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private SessionService sessionService;

	@Autowired
	private CountryRepository<Country> countryRepository;

	@Autowired
	private CountriesService countriesRepository;

	/**
	 * Selects the home page and populates the model with a message
	 */
	@RequestMapping(value = { "", "/", "/home" }, method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome home!");
		model.addAttribute("pageViews", sessionService.getPageViews());
		return "home";
	}

	@RequestMapping(value = "/invoice", method = RequestMethod.GET)
	public String invoice(Model model) {
		logger.info("menu");
		model.addAttribute("pageViews", sessionService.getPageViews());
		return "invoice";
	}

	@RequestMapping(value = "/expenses", method = RequestMethod.GET)
	public String expenses(Model model) {
		logger.info("menu");
		model.addAttribute("pageViews", sessionService.getPageViews());
		return "expenses";
	}

	@RequestMapping(value = "/search/{term}", method = RequestMethod.GET)
	public @ResponseBody
	Object search(@PathVariable String term) {
		Country f = new Country(term.toLowerCase(), "");
		List<Countries> findByName = countriesRepository.search(term);
		logger.info("find = " + findByName);
		return findByName;
		// return countryRepository.get(f);
	}
}
