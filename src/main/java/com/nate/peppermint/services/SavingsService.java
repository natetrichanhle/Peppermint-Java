package com.nate.peppermint.services;

import java.util.List;
import java.util.Optional;

import com.nate.peppermint.models.SavingsAccount;
import com.nate.peppermint.repositories.SavingsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavingsService {

    @Autowired
    private SavingsRepository savingsRepository;

    // retrieves all the savingss
    public List<SavingsAccount> allSavingss() {
        return savingsRepository.findAll();
    }
    // creates a savings
    public SavingsAccount createSavings(SavingsAccount b) {
        return savingsRepository.save(b);
    }
    // retrieves a savings if it exists (optional)
    public SavingsAccount findSavings(Long id) {
        Optional<SavingsAccount> optionalSavings = savingsRepository.findById(id);
        if (optionalSavings.isPresent()) {
            return optionalSavings.get();
        } else {
            return null;
        }
    }

}
