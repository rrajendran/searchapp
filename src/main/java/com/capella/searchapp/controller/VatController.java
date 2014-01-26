package com.capella.searchapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capella.searchapp.model.Vat;
import com.capella.searchapp.respositories.VatRepository;

/**
 * Sample controller for going to the home page with a message
 */
@Controller
@RequestMapping(value = "/vat")
public class VatController {

	private static final Logger logger = LoggerFactory.getLogger(VatController.class);

	@Autowired
	private VatRepository companyRepository;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_USER')")
	public String agencySave(@ModelAttribute Vat vat) {
		Vat c = companyRepository.save(vat);
		System.out.println(c);
		return "redirect:/company/home";
	}

}
