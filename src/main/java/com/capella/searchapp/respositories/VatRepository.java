package com.capella.searchapp.respositories;

import org.springframework.data.repository.CrudRepository;

import com.capella.searchapp.model.Vat;

public interface VatRepository extends CrudRepository<Vat, String> {
}