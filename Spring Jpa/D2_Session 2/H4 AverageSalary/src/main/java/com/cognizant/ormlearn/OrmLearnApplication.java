package com.cognizant.ormlearn;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	// static references
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

		// assigning from context
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);

		// testGetEmployee();
		// testAddEmployee();
		// testUpdateEmployee();
		// testGetDepartment();
		// testAddSkillToEmployee();
		//testGetAllPermanentEmployees();
		testGetAverageSalary();
		LOGGER.info("Start");
	}

	private static void testGetEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);

		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("End");

	}

	public static void testAddEmployee() {
		LOGGER.info("Start");

		Employee employee = new Employee();
		employee.setId(101);
		employee.setName("Pavi");
		employee.setDateOfBirth(Date.valueOf("1999-09-03"));
		employee.setSalary(100.01);
		employee.setPermanent(true);

		Department department = departmentService.get(1);
		employee.setDepartment(department);

		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.info("End");
	}

	public static void testUpdateEmployee() {
		LOGGER.info("Start");

		Employee employee = employeeService.get(6);

		Department department = departmentService.get(2);
		employee.setDepartment(department);

		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.info("End");
	}

	public static void testGetDepartment() {
		LOGGER.info("Start");

		Department department = departmentService.get(3);

		LOGGER.debug("Department:{}", department);
		LOGGER.debug("EmployeeList:{}", department.getEmployeeList());
		LOGGER.info("End");
	}

	public static void testAddSkillToEmployee() {
		Employee employee = employeeService.get(4);
		Skill skill = skillService.get(1);

		Set<Skill> skillList = employee.getSkillList();
		skillList.add(skill);

		employeeService.save(employee);

		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Employee SkillList:{}", employee.getSkillList());
		LOGGER.debug("Skill:{}", skill);
		LOGGER.info("End");
	}

	public static void testGetAllPermanentEmployees() {
		LOGGER.info("Start");
		List<Employee> employees = employeeService.getAllPermanentEmployees();

		LOGGER.debug("Permanent Employees:{}", employees);
		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
		LOGGER.info("End");
	}
	
	public static void testGetAverageSalary() {
		LOGGER.info("Start");
		double avgSalary = employeeService.getAverageSalary();
		
		LOGGER.debug("Average Salary:", avgSalary);		
		LOGGER.info("End");
	}

}
