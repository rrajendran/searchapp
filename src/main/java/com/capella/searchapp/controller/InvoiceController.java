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

import com.capella.searchapp.model.Invoice;
import com.capella.searchapp.respositories.AgencyRepository;
import com.capella.searchapp.respositories.InvoiceRepository;

/**
 * Sample controller for going to the home page with a message
 */
@Controller
public class InvoiceController {

	private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private AgencyRepository agencyRepository;

	/**
	 * Selects the home page and populates the model with a message
	 */
	@RequestMapping(value = { "/invoice/home" }, method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_USER')")
	public String home(Model model) {
		logger.info("Welcome home!");
		model.addAttribute("invoice", new Invoice());
		model.addAttribute("agencies", agencyRepository.findAll());
		return "invoice";
	}

	@RequestMapping(value = "/invoice/save", method = RequestMethod.POST)
	public String agencySave(@ModelAttribute Invoice invoice) {
		invoiceRepository.save(invoice);
		return "redirect:/invoice/home";
	}

	@RequestMapping(value = "/invoice/listInvoice", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('ROLE_USER')")
	public @ResponseBody
	Object listAgency() {
		return (List<Invoice>) invoiceRepository.findAll();
	}
}
