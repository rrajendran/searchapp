package com.capella.searchapp.controller.service;

import java.util.List;
import java.util.Set;

import com.capella.searchapp.controller.model.Country;
import com.capella.searchapp.controller.model.DomainObject;

public interface CountryRepository<V extends DomainObject> {

	void put(V obj);

	Set<Country> get(V key);

	void delete(V key);

	List<V> list();
}