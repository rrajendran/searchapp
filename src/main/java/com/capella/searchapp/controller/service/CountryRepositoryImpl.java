package com.capella.searchapp.controller.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.hsqldb.lib.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.capella.searchapp.controller.HomeController;
import com.capella.searchapp.controller.model.Country;

@Service("countryRepository")
public class CountryRepositoryImpl implements CountryRepository<Country> {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryRepositoryImpl.class);
	@Autowired
	private RedisTemplate<String, Country> redisTemplate;

	@Override
	public void put(Country country) {
		String c = country.getName();
		String temp = "";
		for (int i = 0; i < c.length() - 1; i++) {
			temp += c.charAt(i);
			redisTemplate.opsForZSet().add(temp, country, 0);
		}
	}

	@Override
	public Set<Country> get(Country country) {
		LOGGER.info("",country);
		Set<Country> countries = redisTemplate.opsForZSet().range(
				country.getKey(), 0, 10);
		LOGGER.info("",countries);
		return countries;
	}

	@Override
	public void delete(Country country) {
		redisTemplate.opsForZSet().remove(country.getKey(), country);
	}

	@Override
	public List<Country> list() {
		List<Country> users = new ArrayList<Country>();
		for (Object user : redisTemplate.opsForHash()
				.values(Country.OBJECT_KEY)) {
			users.add((Country) user);
		}
		return users;
	}

	public void init() throws IOException {
		InputStream ins = CountryRepositoryImpl.class.getResourceAsStream("/countries.txt");
		List<String> readLines = IOUtils.readLines(ins);
		for (String countrystr : readLines) {
			Country country = new Country(countrystr.toLowerCase(),countrystr);
			put(country);
		}
	}

	public static void main(String[] args) {
		System.out.println(Locale.UK.getDisplayLanguage());
	}
}
