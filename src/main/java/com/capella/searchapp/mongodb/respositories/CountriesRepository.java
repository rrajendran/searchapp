package com.capella.searchapp.mongodb.respositories;

import java.util.List;

import com.capella.searchapp.mongodb.model.Countries;

public interface CountriesRepository {
	List<Countries> findByName(String searchString);
}
