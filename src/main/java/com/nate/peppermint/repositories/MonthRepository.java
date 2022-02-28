package com.nate.peppermint.repositories;

import java.util.List;

import com.nate.peppermint.models.Month;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface MonthRepository extends CrudRepository<Month, Long> {
    // CrudRepository holds all the CRUD operations
    // "Long" is the datatype of the primary key
    // How JPA works to create custom queries following a certain format
    // depending on the method signature
    List<Month> findAll(); // this method retrieves all the books from the database

    List<Month> findByMonthOfYearContaining(String search); // this method finds books with descriptions containing the search string

    // Long countByTitleContaining(String search); // this method counts how many titles contain a certain string

    // Long deleteByTitleStartingWith(String search); // this method deletes a book that starts with a specific title
}