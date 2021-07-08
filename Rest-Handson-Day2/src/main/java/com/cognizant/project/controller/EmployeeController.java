package com.cognizant.project.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.project.exception.EmployeeNotFoundException;
import com.cognizant.project.model.Employee;
import com.cognizant.project.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees")
	public ResponseEntity<ArrayList<Employee>> getAllEmployees() {
		ArrayList<Employee> emp = employeeService.getAllEmployee();
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	@PutMapping("/employees/update")
	public ResponseEntity<String> updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException
	{
		
		employeeService.updateEmployee(employee);
		return new ResponseEntity<String>("Employee Updated Successfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/employees/delete")
	public ResponseEntity<String> deleteMapping(@RequestBody @Valid Employee employee)throws EmployeeNotFoundException
	{
		employeeService.deleteEmployee(employee);
		return new ResponseEntity<String>("Employee Deleted Successfully", HttpStatus.OK);
		
	}
}
