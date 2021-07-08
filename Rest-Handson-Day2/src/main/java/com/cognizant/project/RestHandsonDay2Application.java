package com.cognizant.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.cognizant.project.service.EmployeeService;

@SpringBootApplication
@ComponentScan("com.cognizant")
public class RestHandsonDay2Application {
	
	public static void main(String[] args) {
		SpringApplication.run(RestHandsonDay2Application.class, args);	
	}
}
