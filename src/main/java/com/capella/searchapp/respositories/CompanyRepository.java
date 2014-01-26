package com.capella.searchapp.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capella.searchapp.model.Company;

public interface CompanyRepository extends CrudRepository<Company, String> {
	List<Company> findByCompanyName(String companyName);
}