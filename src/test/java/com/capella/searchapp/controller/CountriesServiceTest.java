package com.capella.searchapp.controller;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capella.searchapp.model.Address;
import com.capella.searchapp.model.Agency;
import com.capella.searchapp.model.Company;
import com.capella.searchapp.model.Invoice;
import com.capella.searchapp.model.Vat;
import com.capella.searchapp.respositories.AgencyRepository;
import com.capella.searchapp.respositories.CompanyRepository;
import com.capella.searchapp.respositories.InvoiceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class CountriesServiceTest {

	@Autowired
	AgencyRepository customerRepository;
	@Autowired
	InvoiceRepository invoiceRepository;
	@Autowired
	CompanyRepository companyRepository;

	@Test
	public void test() {
		Agency agency = customerRepository.findOne(1l);
		System.out.println(agency);
		Invoice invoice = new Invoice();
		invoice.setAgency(agency);
		invoice.setDays(5);
		invoice.setFromDate(DateTime.now());
		invoice.setToDate(DateTime.now().plusDays(5));
		invoice.setRate(360d);
		invoice.setVat(20d);
		Invoice save = invoiceRepository.save(invoice);
		System.out.println(save);
	}

	@Test
	public void test_company() {
		Company company = new Company();
		company.setCompanyNo("2352435");
		Address address = new Address();
		address.setAddress1("18, Advent House");
		address.setAddress2("2,Issac Way");
		address.setCity("Manchester");
		address.setPostCode("M4 7EP");
		company.setAddress(address);
		company.setIncorporationDate(DateTime.now().minusYears(3));
		company.setCompanyName("Capella Technologies");
		Vat vat = new Vat();
		vat.setRegistrationNo("992945754");
		vat.setRegistrationDate(DateTime.parse("2010-06-20"));
		vat.setVatRate(20d);
		company.setVat(vat);
		company = companyRepository.save(company);

		System.out.println(company);

	}
}
