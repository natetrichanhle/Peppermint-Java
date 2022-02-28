package com.nate.peppermint.repositories;

import java.util.List;

import com.nate.peppermint.models.Budget;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends CrudRepository<Budget, Long> {
    List<Budget> findAll();
}
