package com.cognizant.quiz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.quiz.model.Attempt;
import com.cognizant.quiz.service.AttemptService;

@SpringBootApplication
public class QuizApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(QuizApplication.class);

	// static references
	private static AttemptService attemptService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(QuizApplication.class, args);

		// assigning from context
		attemptService = context.getBean(AttemptService.class);

		testGetAttempt();
		LOGGER.info("Start");
	}

	private static void testGetAttempt() {
		LOGGER.info("Start");
		Attempt attempt = attemptService.getAttempt(1, 1);

		LOGGER.debug("Attempt:{}", attempt);
		
		LOGGER.info("End");
	}
}
