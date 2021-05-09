package org.example;

import java.util.Scanner;

import org.example.dao.TraineeDaoImpl;

public class Application {
	private static TraineeDaoImpl traineeDaoImpl = new TraineeDaoImpl();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome!" + "\n" + "Select an option?");
		int choice = 0;
		do {
			System.out.println("\n1. Register a trainee" + "\n" + "2. remove trainee" + "\n"
					+ "3. Find trainee by name " + "\n" + "4. Find trainee by cohurt code" + "\n" + "5.Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				sc.nextLine();
				System.out.println("Enter trainee name:");
				String name = sc.nextLine();
				System.out.println("Enter email:");
				String email = sc.next();
				System.out.println("Enter emp id");
				int empid = sc.nextInt();
				System.out.println("Enter cohurt code");
				String cohurtCode = sc.next();
				
				traineeDaoImpl.registerTrainee(name, email, empid, cohurtCode);
				break;
			
			case 2:
				System.out.println("Enter trainee id to remove");
				int id = sc.nextInt();

				traineeDaoImpl.removeTrainee(id);
				break;
				
			case 3: {
				System.out.println("Enter trainee name to find");
				String traineeName = sc.next();
				
				traineeDaoImpl.findTraineeByName(traineeName);				
				break;
			}
			
			case 4:
				System.out.println("Enter cohurt code to find");
				String code = sc.next();
				
				traineeDaoImpl.findTraineeByName(code);				
				break;
			}
		} while (choice != 5);

		System.out.println("Thank You!!!");
	}
}