package com.nate.peppermint.repositories;

import java.util.List;

import com.nate.peppermint.models.Goal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends CrudRepository<Goal, Long> {
    List<Goal> findAll();
}



