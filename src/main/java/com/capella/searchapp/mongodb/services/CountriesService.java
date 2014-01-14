package com.capella.searchapp.mongodb.services;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.capella.searchapp.mongodb.model.Countries;

@Service
public class CountriesService {
	MongoTemplate mongoTemplate;

	@Autowired
	public CountriesService(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public void init() {
		Locale[] locales = Locale.getAvailableLocales();
		for (Locale locale : locales) {
			Countries countries = new Countries();
			countries.setLanguage(locale.getDisplayLanguage());
			countries.setName(locale.getDisplayCountry());
			mongoTemplate.save(countries);
		}

	}

	public List<Countries> search(String name) {
		System.out.println("search = " + name);
		Criteria languageCriteria = Criteria.where("language").regex(name, "i");
		Criteria criteria = Criteria.where("name").regex(name, "i"); // .orOperator(languageCriteria);
		Query query = new Query(criteria);
		return mongoTemplate.find(query, Countries.class);
	}
}
