package com.capella.searchapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.capella.searchapp.model.Country;

@Service("countryRepository")
public class CountryRepositoryImpl implements CountryRepository<Country> {

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
		System.out.println(country);
		Set<Country> countries = redisTemplate.opsForZSet().range(
				country.getKey(), 0, 10);
		
		System.out.println(countries);
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

	public void init() {
		Locale[] locales = Locale.getAvailableLocales();
		for (Locale locale : locales) {
			Country country = new Country(locale.getDisplayCountry()
					.toLowerCase(), locale.getDisplayLanguage().toLowerCase());
			put(country);

		}
		System.out.println(list());
	}

	public static void main(String[] args) {
		System.out.println(Locale.UK.getDisplayLanguage());
	}
}
