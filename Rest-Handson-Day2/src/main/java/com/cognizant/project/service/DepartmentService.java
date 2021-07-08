package com.cognizant.project.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.cognizant.project.dao.DepartmentDao;
import com.cognizant.project.model.Department;

@Service
public class DepartmentService {

	DepartmentDao departmentDao = new DepartmentDao();

	public ArrayList<Department> getAllDepartments() {
		return departmentDao.getAllDepartments();
	}

}
