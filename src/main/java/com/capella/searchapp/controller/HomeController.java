package com.capella.searchapp.controller;

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

/**
 * Sample controller for going to the home page with a message
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private SessionService sessionService;

	@Autowired
	private CountryRepository<Country> countryRepository;

	/**
	 * Selects the home page and populates the model with a message
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome home!");
		model.addAttribute(
				"pageViews", sessionService.getPageViews());
		return "home";
	}

	@RequestMapping(value = "/search/{term}", method = RequestMethod.GET)
	public @ResponseBody
	Object search(@PathVariable String term) {
		Country f = new Country(term.toLowerCase(), "");
		return countryRepository.get(f);
	}
}
