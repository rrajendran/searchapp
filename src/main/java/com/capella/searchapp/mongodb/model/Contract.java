package com.capella.searchapp.mongodb.model;

import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Contract {
	@Id
	private ObjectId contractId;
	private DateTime startDate;
	private DateTime endDate;
	private Contract parentContract;
	private ObjectId agencyId;
	private ObjectId clientId;
	
	public ObjectId getContractId() {
		return contractId;
	}
	public void setContractId(ObjectId contractId) {
		this.contractId = contractId;
	}
	public DateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}
	public DateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}
	public Contract getParentContract() {
		return parentContract;
	}
	public void setParentContract(Contract parentContract) {
		this.parentContract = parentContract;
	}
	public ObjectId getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(ObjectId agencyId) {
		this.agencyId = agencyId;
	}
	public ObjectId getClientId() {
		return clientId;
	}
	public void setClientId(ObjectId clientId) {
		this.clientId = clientId;
	}
}
