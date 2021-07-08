package com.cognizant.project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.project.model.Department;
import com.cognizant.project.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@GetMapping("/departments")
	public ResponseEntity<ArrayList<Department>> getAllDepartment() {
		ArrayList<Department> dep = departmentService.getAllDepartments();

		return new ResponseEntity<>(dep, HttpStatus.OK);
	}

}
