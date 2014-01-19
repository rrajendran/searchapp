package com.capella.searchapp.respositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capella.searchapp.model.Agency;
public interface CustomerRepository extends CrudRepository<Agency, Long> {
    List<Agency> findByName(String name);
}