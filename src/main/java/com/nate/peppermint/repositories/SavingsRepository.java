package com.nate.peppermint.repositories;


import java.util.List;

import com.nate.peppermint.models.SavingsAccount;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SavingsRepository extends CrudRepository<SavingsAccount, Long> {
    // CrudRepository holds all the CRUD operations
    // "Long" is the datatype of the primary key
    // How JPA works to create custom queries following a certain format
    // depending on the method signature
    List<SavingsAccount> findAll(); // this method retrieves all the books from the database

}
