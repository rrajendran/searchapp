package com.capella.searchapp.mongodb.model;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Contract {
	@Id
	private Long contractId;
	private DateTime startDate;
	private DateTime endDate;
	private Contract parentContract;
	private Agency agency;
	private Client client;
	public Long getContractId() {
		return contractId;
	}
	public void setContractId(Long contractId) {
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
	public Agency getAgency() {
		return agency;
	}
	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@Override
	public String toString() {
		return "Contract [contractId=" + contractId + ", startDate="
				+ startDate + ", endDate=" + endDate + ", parentContract="
				+ parentContract + ", agency=" + agency + ", client=" + client
				+ "]";
	}
	

}
