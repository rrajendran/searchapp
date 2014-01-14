package com.capella.searchapp.mongodb.respositories;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capella.searchapp.mongodb.model.Countries;

@Service
public class CountriesRepositoryImpl implements CountriesRepository {

	@Override
	public List<Countries> findByName(String searchString) {
		// TODO Auto-generated method stub
		return null;
	}

}
