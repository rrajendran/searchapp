package com.capella.searchapp.respositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capella.searchapp.model.Invoice;
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
   
}