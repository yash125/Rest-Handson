package com.cognizant.project.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.cognizant.project.dao.EmployeeDao;
import com.cognizant.project.exception.EmployeeNotFoundException;
import com.cognizant.project.model.Employee;

@Service
public class EmployeeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	
	EmployeeDao employeeDao = new EmployeeDao();
	
	
	
	public ArrayList<Employee> getAllEmployee()
	{
		return employeeDao.getAllEmployee();
	}
	
	public void updateEmployee(Employee emp) throws EmployeeNotFoundException
	{
		employeeDao.updateEmployee(emp);
	}
	
	public void deleteEmployee(Employee emp) throws EmployeeNotFoundException
	{
		employeeDao.deleteEmployee(emp);
	}
}
