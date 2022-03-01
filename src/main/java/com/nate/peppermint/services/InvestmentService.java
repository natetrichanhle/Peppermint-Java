package com.nate.peppermint.services;

import java.util.List;
import java.util.Optional;

import com.nate.peppermint.models.Investment;
import com.nate.peppermint.repositories.InvestmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestmentService {
	// adding the investment repository as a dependency
	@Autowired
    private InvestmentRepository investmentRepository;

	// returns all the investments
	public List<Investment> allInvestments() {
		return investmentRepository.findAll();
	}

	// creates a investment
	public Investment createInvestment(Investment inv) {
		return investmentRepository.save(inv);
	}

	// retrieves a investment
	public Investment findInvestment(Long id) {
		Optional<Investment> optionalInvestment = investmentRepository.findById(id);
		if (optionalInvestment.isPresent()) {
			return optionalInvestment.get();
		} else {
			return null;
		}
	}

	public Investment updateInvestment(Investment updatedInvestment) {
			return investmentRepository.save(updatedInvestment);
	}

	public void deleteInvestment(Long id) {
			investmentRepository.deleteById(id);			
	}
}
