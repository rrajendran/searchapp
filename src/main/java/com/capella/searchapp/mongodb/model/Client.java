package com.capella.searchapp.mongodb.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Client {
	@Id
	private ObjectId id;
	private String name;
	private ObjectId contactId;
	private Address address;
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ObjectId getContactId() {
		return contactId;
	}
	public void setContactId(ObjectId contactId) {
		this.contactId = contactId;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", contactId="
				+ contactId + ", address=" + address + "]";
	}
	
}
