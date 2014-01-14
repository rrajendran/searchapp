package com.capella.searchapp.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capella.searchapp.mongodb.model.Countries;
import com.capella.searchapp.mongodb.respositories.CountriesRepository;
import com.capella.searchapp.mongodb.services.CountriesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class CountriesServiceTest {

	@Autowired
	CountriesService countriesService;

	@Autowired
	CountriesRepository repository;

	@Test
	public void testController() {
		List<Countries> search = countriesService.search("india");
		System.out.println(search);
	}
}
