package com.nate.peppermint.services;

import java.util.List;
import java.util.Optional;

import com.nate.peppermint.models.Goal;
import com.nate.peppermint.repositories.GoalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalService {
	// adding the goal repository as a dependency
	@Autowired
    private GoalRepository goalRepository;

	// returns all the goals
	public List<Goal> allGoals() {
		return goalRepository.findAll();
	}

	// creates a goal
	public Goal createGoal(Goal b) {
		return goalRepository.save(b);
	}

	// retrieves a goal
	public Goal findGoal(Long id) {
		Optional<Goal> optionalGoal = goalRepository.findById(id);
		if (optionalGoal.isPresent()) {
			return optionalGoal.get();
		} else {
			return null;
		}
	}

	public Goal updateGoal(Goal updatedGoal) {
			return goalRepository.save(updatedGoal);
	}

	public void deleteGoal(Long id) {
			goalRepository.deleteById(id);			
	}
}