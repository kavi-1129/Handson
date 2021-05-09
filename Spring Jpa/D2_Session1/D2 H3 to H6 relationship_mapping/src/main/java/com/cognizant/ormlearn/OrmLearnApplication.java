package com.cognizant.ormlearn;

import java.sql.Date;
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
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

	private static DepartmentService departmentService;
	private static EmployeeService employeeService;
	private static SkillService skillService;

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	public static void main(String[] args) throws CountryNotFoundException {

		LOGGER.info("Inside main");

		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		departmentService = context.getBean(DepartmentService.class);
		employeeService =context.getBean(EmployeeService.class);
		skillService =context.getBean(SkillService.class);

		testGetEmployee();
		testAddEmployee();
		testUpdateEmployee();
		testGetDepartment();
		testAddSkillToEmployee();
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
	
	private static void testAddEmployee(){
		LOGGER.info("Test Add employee");
        Employee employee = new Employee();
        employee.setId(100);
        employee.setName("kavi");
        employee.setSalary(10000.00);
        employee.setPermanent(true);
        employee.setDateOfBirth(Date.valueOf("1999-11-29"));
        
        Department department = departmentService.get(1);
        employee.setDepartment(department);
        
        employeeService.save(employee);
        LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
        LOGGER.info("Test End employee");
	}
	
	private static void testUpdateEmployee() {

		LOGGER.info("Test Start Update");
        Employee employee = employeeService.get(6);
        Department department = departmentService.get(3);
        employee.setDepartment(department);
        employeeService.save(employee);
        
        LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
        LOGGER.info("Test End Update");

		}
		
	public static void testGetDepartment() {
		LOGGER.info("start test department");

		Department department = departmentService.get(3);

		LOGGER.debug("Department:{}", department);
		LOGGER.debug("EmployeeList:{}", department.getEmployeeList());
		LOGGER.info("End test department");
	}
	
	public static void testAddSkillToEmployee() {
		LOGGER.info("start test addskillemployee");
		Employee employee = employeeService.get(4);
		Skill skill = skillService.get(1);
		
		Set<Skill> skillList = employee.getSkillList();
		skillList.add(skill);
		
		employeeService.save(employee);
		
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Employee SkillList:{}", employee.getSkillList());
		LOGGER.debug("Skill:{}", skill);
		LOGGER.info("End test addskillemployee");
	}
	
	

}
