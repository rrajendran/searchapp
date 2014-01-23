package com.capella.searchapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.capella.searchapp.model.Agency;
import com.capella.searchapp.respositories.AgencyRepository;

/**
 * Sample controller for going to the home page with a message
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private AgencyRepository customerRepository;

	@RequestMapping(value = "/agency/save", method = RequestMethod.POST)
	public String  agencySave(@ModelAttribute Agency agency) {
		customerRepository.save(agency);
		return "redirect:/";
	}



	@RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody
	Map<String, List<Agency>> search(@PathVariable String name) {
		Map<String,List<Agency>> map = new HashMap<String, List<Agency>>();
		map.put("agencies",  (List<Agency>) customerRepository.findByName(name));
		return map;
	}

	@RequestMapping(value = "/listAgency", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody
	Object listAgency() {
		return (List<Agency>) customerRepository.findAll();
	}
}
