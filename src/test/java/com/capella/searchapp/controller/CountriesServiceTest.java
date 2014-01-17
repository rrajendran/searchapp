package com.capella.searchapp.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capella.searchapp.mongodb.model.Address;
import com.capella.searchapp.mongodb.model.Agency;
import com.capella.searchapp.mongodb.model.Client;
import com.capella.searchapp.mongodb.model.Contact;
import com.capella.searchapp.mongodb.model.Contract;
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
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Test
	public void testController() {
		List<Countries> search = countriesService.search("india");
		System.out.println(search);
	}
	
	@Test
	public void insertContract(){
		Contract contract = new Contract();
		contract.setContractId(new ObjectId());
		contract.setEndDate(DateTime.now().plusMonths(3));
		contract.setParentContract(null);
		contract.setStartDate(DateTime.now());
		Agency agency = createAgency();
		contract.setAgencyId(agency.getId() );
		Client client = createClient();
		contract.setClientId(client.getId());
		mongoTemplate.insert(contract, "contract");
	}
	
	public Agency createAgency(){
		Agency agency = new Agency();
		agency.setId(new ObjectId());
		Address address = new Address();
		address.setPostCode("M4 7EP");
		agency.setAddress(address );
		Contact contact = createContact();
		agency.setContactId(contact.getId() );
		agency.setName("Harvey Nash");
		mongoTemplate.insert(agency, "agency");
		return agency;
	}

	private Contact createContact() {
		Contact contact = new Contact();
		contact.setFirstName("Michael");
		contact.setLastName("Hall");
		contact.setMobilePhone("07769250816");
		contact.setEmailId("michael.hall@harveynash.com");
		mongoTemplate.insert(contact, "contact");
		return contact;
	}
	
	public Client createClient(){
		Client client = new Client();
		client.setName("boohoo.com");
		Address address = new Address();
		address.setPostCode("M4 7EP");
		client.setAddress(address);
		Contact contact = createContact();
		client.setContactId(contact.getId());
		mongoTemplate.insert(client, "client");
		return client;
	}
}
