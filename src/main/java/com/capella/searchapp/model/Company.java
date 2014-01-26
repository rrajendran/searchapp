package com.capella.searchapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "company")
public class Company {
	private String companyNo;
	private String companyName;
	private Address address;
	private DateTime incorporationDate;
	private Vat vat;

	@Id
	@Column(name = "company_no")
	public String getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}

	@Column(name = "company_name")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Embedded
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name = "incorporation_date")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getIncorporationDate() {
		return incorporationDate;
	}

	public void setIncorporationDate(DateTime incorporationDate) {
		this.incorporationDate = incorporationDate;
	}

	@OneToOne(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Vat getVat() {
		return vat;
	}

	public void setVat(Vat vat) {
		this.vat = vat;
	}

	@Override
	public String toString() {
		return "Company [companyNo=" + companyNo + ", companyName=" + companyName + ", address=" + address + ", incorporationDate="
				+ incorporationDate + ", vat=" + vat + "]";
	}

}
