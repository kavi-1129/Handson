package org.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.example.exception.InvalidTraineeDataException;
import org.example.model.Trainee;


public class TraineeDaoImpl implements TraineeDao {

	private List<Trainee> TraineeList;

	public TraineeDaoImpl() {
		this.TraineeList = new ArrayList<Trainee>();
	}

	public void registerTrainee(String name, String email, int empid, String cohurtCode) {

		// email constraint
		String validEmail = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern emailPattern = Pattern.compile(validEmail);
		Matcher emailMatcher = emailPattern.matcher(email);
		if (!emailMatcher.matches()) {
			throw new InvalidTraineeDataException("Make sure email is in correct format\n");
		}

		// name constraint
		char[] chars = name.toCharArray();
		for (char c : chars) {
			if (Character.isDigit(c))
				throw new InvalidTraineeDataException("Name cannot have numeric data");
		}

		// id constraint
		if (String.valueOf(empid).length() != 6) {
			throw new InvalidTraineeDataException("Empid should have 6 numbers");
		}

		// cohort constraint AAAXXAAXX
		String validCohurt = "^[A-Za-z]{3}[0-9]{2}[A-Za-z]{2}[0-9]{2}";
		Pattern cohurtPattern = Pattern.compile(validCohurt);
		Matcher cohurtMatcher = cohurtPattern.matcher(cohurtCode);
		if (!cohurtMatcher.matches()) {
			throw new InvalidTraineeDataException("Error! Please enter with format AAAXXAAXX");
		}

		Trainee trainee = new Trainee(name, email, empid, cohurtCode);
		TraineeList.add(trainee);
		System.out.println("Trainee added successfully");
	}

	public void removeTrainee(int empid) {
		for (Trainee trainee : TraineeList) {
			if (trainee.getEmpid() == empid) {
				TraineeList.remove(trainee);
				System.out.println("Trainee removed successfully");
				break;
			}
		}

	}

	public void findTraineeByName(String name) {
		for (Trainee trainee : TraineeList) {
			if (trainee.getName().equals(name))
				System.out.println("Trainee found with name:" + name + "Trainee cohurt code: " + trainee.getCohurtCode()
						+ "Trainee emp id: " + trainee.getEmpid() + "Trainee email: " + trainee.getEmail());
		}
	}

	public void findAll(String cohurtCode) {
		for (Trainee trainee : TraineeList) {
			if (trainee.getCohurtCode().equals(cohurtCode)) {
				System.out.println("Trainee found with cohurt code:" + cohurtCode + "Trainee name: " + trainee.getName()
						+ "Trainee emp id: " + trainee.getEmpid() + "Trainee email: " + trainee.getEmail());
			}
		}
	}

}
