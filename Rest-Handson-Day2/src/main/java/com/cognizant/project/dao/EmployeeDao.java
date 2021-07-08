package com.cognizant.project.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.project.exception.EmployeeNotFoundException;
import com.cognizant.project.model.Employee;

public class EmployeeDao {

	private static ArrayList<Employee> EMPLOYEE_LIST = new ArrayList<Employee>();

	@SuppressWarnings("unchecked")
	public EmployeeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList", java.util.ArrayList.class);

	}

	public ArrayList<Employee> getAllEmployee() {
		return EMPLOYEE_LIST;
	}

	public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
		int flag=0;
		for(Employee e : EMPLOYEE_LIST)
		{
			if(employee.getId()==e.getId())
			{
				employee.setName("XYZ");
				flag=1;
				break;
			}
		}
		if(flag==0)
		throw new EmployeeNotFoundException();

	}
	
	public void deleteEmployee(Employee employee) throws EmployeeNotFoundException {
		int flag=0;
		for(int i=0;i<EMPLOYEE_LIST.size();i++)
		{
			if(EMPLOYEE_LIST.get(i).getId()==employee.getId())
			{
				EMPLOYEE_LIST.remove(i);
				flag=1;
			}
		}
		if(flag==0)
		throw new EmployeeNotFoundException();

	}

}
