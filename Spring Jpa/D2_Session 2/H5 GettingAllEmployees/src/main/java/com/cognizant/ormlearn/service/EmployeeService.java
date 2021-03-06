package com.cognizant.ormlearn.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

	// EmployeeService - get() method
	@Transactional
	public Employee get(int id) {
		LOGGER.info("Start");

		return employeeRepository.findById(id).get();
	}

	// EmployeeService - save() method
	@Transactional
	public void save(Employee employee) {
		LOGGER.info("Start");
		employeeRepository.save(employee);

		LOGGER.info("End");
	}

	public List<Employee> getAllPermanentEmployees() {
		return employeeRepository.getAllPermanentEmployee();
	}

	public double getAverageSalary() {
		return employeeRepository.getAverageSalary(1);
	}
	
	public List<Employee> getAllEmployeesNative() {
		return employeeRepository.getAllEmployeeNative();
	}
}