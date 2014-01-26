package com.capella.searchapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.capella.searchapp.model.Company;
import com.capella.searchapp.respositories.CompanyRepository;
import com.capella.searchapp.respositories.VatRepository;

/**
 * Sample controller for going to the home page with a message
 */
@Controller
@RequestMapping(value = "/company")
public class CompanyController {

	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private VatRepository vatRepository;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_USER')")
	public String agency(Model model) {
		Company company = companyRepository.findOne("7273867");
		if (company == null)
			company = new Company();
		model.addAttribute("company", company);
		model.addAttribute("vat", vatRepository.findOne("992945754"));
		return "company";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_USER')")
	public String agencySave(@ModelAttribute Company company) {
		Company c = companyRepository.save(company);
		System.out.println(c);
		return "redirect:/company/home";
	}

	@RequestMapping(value = "/listCompany", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody
	@PreAuthorize("hasRole('ROLE_USER')")
	Object listAgency() {
		return (List<Company>) companyRepository.findAll();
	}
}
