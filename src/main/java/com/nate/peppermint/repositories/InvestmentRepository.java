package com.nate.peppermint.repositories;

import java.util.List;

import com.nate.peppermint.models.Investment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentRepository extends CrudRepository<Investment, Long> {
    List<Investment> findAll();
}




