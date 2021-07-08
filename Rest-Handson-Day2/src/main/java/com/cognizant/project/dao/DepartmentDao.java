package com.cognizant.project.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.project.model.Department;

public class DepartmentDao {

	private static ArrayList<Department> DEPARTMENT_LIST = new ArrayList<Department>();

	public DepartmentDao() {

		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		DEPARTMENT_LIST = (ArrayList<Department>) context.getBean("departmentList", java.util.ArrayList.class);

	}

	public ArrayList<Department> getAllDepartments() {
		return DEPARTMENT_LIST;
	}

}
