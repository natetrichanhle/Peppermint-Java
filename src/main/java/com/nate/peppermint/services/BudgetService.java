package com.nate.peppermint.services;

import java.util.List;
import java.util.Optional;

import com.nate.peppermint.models.Budget;
import com.nate.peppermint.repositories.BudgetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetService {
	// adding the budget repository as a dependency
	@Autowired
    private BudgetRepository budgetRepository;

	// returns all the budgets
	public List<Budget> allBudgets() {
		return budgetRepository.findAll();
	}

	// creates a budget
	public Budget createBudget(Budget b) {
		return budgetRepository.save(b);
	}

	// retrieves a budget
	public Budget findBudget(Long id) {
		Optional<Budget> optionalBudget = budgetRepository.findById(id);
		if (optionalBudget.isPresent()) {
			return optionalBudget.get();
		} else {
			return null;
		}
	}

	public Budget updateBudget(Budget updatedBudget) {
			return budgetRepository.save(updatedBudget);
	}

	public void deleteBudget(Long id) {
			budgetRepository.deleteById(id);			
	}
}
