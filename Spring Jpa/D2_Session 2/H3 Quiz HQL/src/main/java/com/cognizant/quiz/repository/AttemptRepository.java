package com.cognizant.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.quiz.model.Attempt;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Integer> {

	@Query(value = "SELECT * FROM Attempt a Join User u WHERE a.at_us_id = u.us_id", nativeQuery = true)
	//@Query(value = "SELECT u.userId, a.attemptId FROM Attempt as a JOIN a.user as u WHERE u.userId = a.attemptId")
	public Attempt getAttempt(int userId, int attemptId);

}
