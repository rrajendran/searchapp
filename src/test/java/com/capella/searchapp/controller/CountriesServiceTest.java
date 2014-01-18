package com.capella.searchapp.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capella.searchapp.model.Agency;
import com.capella.searchapp.respositories.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class CountriesServiceTest {

	@Autowired
	CustomerRepository customerRepository;
	
	@Test
	public void test(){
		Agency customer = new Agency("Ramesh", "Rajendran");
		Agency save = customerRepository.save(customer );
		System.out.println(save);
	}
}
