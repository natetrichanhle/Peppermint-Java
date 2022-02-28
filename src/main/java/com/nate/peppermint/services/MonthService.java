package com.nate.peppermint.services;

import java.util.List;
import java.util.Optional;

import com.nate.peppermint.models.Month;
import com.nate.peppermint.repositories.MonthRepository;

import org.springframework.stereotype.Service;

@Service
public class MonthService {
    private final MonthRepository monthRepository;

    // Constructor
    public MonthService(MonthRepository monthRepository) {
        this.monthRepository = monthRepository;
    }

    // retrieves all the Months
    public List<Month> allMonths() {
        return monthRepository.findAll();
    }

    // creates a Month
    public Month createMonth(Month month, int monthNumber) {

        if(monthNumber == 1){
            month.setMonthOfYear("January");
        }
        if(monthNumber == 2){
            month.setMonthOfYear("Feburary");
        }
        if(monthNumber == 3){
            month.setMonthOfYear("March");
        }
        if(monthNumber == 4){
            month.setMonthOfYear("April");
        }
        if(monthNumber == 5){
            month.setMonthOfYear("May");
        }
        if(monthNumber == 6){
            month.setMonthOfYear("June");
        }
        if(monthNumber == 7){
            month.setMonthOfYear("July");
        }
        if(monthNumber == 8){
            month.setMonthOfYear("August");
        }
        if(monthNumber == 9){
            month.setMonthOfYear("September");
        }
        if(monthNumber == 10){
            month.setMonthOfYear("October");
        }
        if(monthNumber == 11){
            month.setMonthOfYear("November");
        }
        if(monthNumber == 12){
            month.setMonthOfYear("December");
        }
        return monthRepository.save(month);
    }

    // updates a Month
    public Month updateMonth(Month month) {
        return monthRepository.save(month);
    }

    // retrieves a Month if it exists (optional)
    public Month findMonth(Long id) {
        Optional<Month> optionalMonth = monthRepository.findById(id);
        if (optionalMonth.isPresent()) {
            return optionalMonth.get();
        } else {
            return null;
        }
    }
}
