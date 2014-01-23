package com.capella.searchapp.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name="INVOICE")
public class Invoice {
	private long id;
	@JsonManagedReference 
	private Agency agency;
	private DateTime fromDate;
	private DateTime toDate;
	private Double rate;
	private Integer days;
	private Double vat;
	
	public Invoice() {

	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name="AGENCY_ID")
	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	@Column(name="FROM_DATE")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getFromDate() {
		return fromDate;
	}
	public void setFromDate(DateTime fromDate) {
		this.fromDate = fromDate;
	}
	@Column(name="TO_DATE")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getToDate() {
		return toDate;
	}
	public void setToDate(DateTime toDate) {
		this.toDate = toDate;
	}
	@Column(name="RATE")
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	@Column(name="DAYS")
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	@Column(name="VAT")
	public Double getVat() {
		return vat;
	}
	public void setVat(Double vat) {
		this.vat = vat;
	}
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", agency=" + agency + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", rate=" + rate
				+ ", days=" + days + "]";
	}
}