package com.capella.searchapp.controller.model;

public class Country implements DomainObject {
	private static final long serialVersionUID = 1L;
	public static final String OBJECT_KEY = "COUNTRY";
	String name;
	String abbrevation;

	public Country() {
	}

	

	public Country(String name, String abbrevation) {
		super();
		this.name = name;
		this.abbrevation = abbrevation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbrevation() {
		return abbrevation;
	}

	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}

	@Override
	public String getKey() {
		return getName();
	}

	@Override
	public String getObjectKey() {
		return OBJECT_KEY;
	}



	@Override
	public String toString() {
		return "Country [name=" + name + ", abbrevation=" + abbrevation + "]";
	}

 

}