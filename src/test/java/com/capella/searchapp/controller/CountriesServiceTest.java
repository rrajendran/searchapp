package com.capella.searchapp.controller;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capella.searchapp.model.Agency;
import com.capella.searchapp.model.Invoice;
import com.capella.searchapp.respositories.AgencyRepository;
import com.capella.searchapp.respositories.InvoiceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class CountriesServiceTest {

	@Autowired
	AgencyRepository customerRepository;
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Test
	public void test(){
		Agency agency = customerRepository.findOne(1l);
		System.out.println(agency);
		Invoice invoice = new Invoice();
		invoice.setAgency(agency);
		invoice.setDays(5);
		invoice.setFromDate(DateTime.now());
		invoice.setToDate(DateTime.now().plusDays(5));
		invoice.setRate(360d);
		invoice.setVat(20d);
		Invoice save = invoiceRepository.save(invoice );
		System.out.println(save);
	}
}
