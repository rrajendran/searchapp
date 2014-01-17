package com.capella.searchapp.mongodb.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Address {
	private String address1;
	private String address2;
	private String city;
	private String town;
	private String country;
	private String postCode;
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	@Override
	public String toString() {
		return "Address [address1=" + address1 + ", address2=" + address2
				+ ", city=" + city + ", town=" + town + ", country=" + country
				+ ", postCode=" + postCode + "]";
	}
	
}
