package com.capella.searchapp.model;

public class Country implements DomainObject {
	private static final long serialVersionUID = 1L;
	public static final String OBJECT_KEY = "COUNTRY";
	String name;
	String language;

	public Country() {
	}

	public Country(String name, String language) {
		this.name = name;
		this.language = language;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
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
		return "Country [name=" + name + ", language=" + language + "]";
	}

}