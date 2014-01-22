package com.capella.searchapp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.capella.searchapp.model.Agency;
import com.capella.searchapp.model.Company;
import com.capella.searchapp.respositories.CustomerRepository;

/**
 * Sample controller for going to the home page with a message
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * Selects the home page and populates the model with a message
	 */
	@RequestMapping(value = { "", "/", "/home" }, method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome home!");
		model.addAttribute("agency", new Agency());
		return "home";
	}

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
		// return countryRepository.get(f);
	}

	@RequestMapping(value = "/listAgencies", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void listAgencies(@RequestParam(value="callback") String callBack, HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		Map<String,List<Agency>> map = new HashMap<String, List<Agency>>();
		map.put("agencies",  (List<Agency>) customerRepository.findAll());
		response.setHeader("content-type", "application/json");
		String json = objectMapper.writeValueAsString(new JSONPObject(callBack,map));
		response.getWriter().write(json);
	}

	@RequestMapping(value = "/listCompany", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody
	Map<String, Company> listCompany() {
		Map<String,Company> map = new HashMap<String,Company>();
		map.put("company",  new Company(1l,"Capell Technologies Ltd"));
		return map;
	}
}
