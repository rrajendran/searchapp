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

}
