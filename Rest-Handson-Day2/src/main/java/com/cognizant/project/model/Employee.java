package com.cognizant.project.model;

import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Employee {
	
	@NotNull
	private int id;
	@NotNull
	@NotBlank
	@Size(min=1, max=30)
	private String name;
	@NotNull
	@DecimalMin("0.0")
	private double salary;
	@NotNull
	private boolean permanent;
	private Department department;
	private Skill skills;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date date;
	public Employee(int id, String name, double salary, boolean permanent, Department department, Skill skills,
			Date date) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.permanent = permanent;
		this.department = department;
		this.skills = skills;
		this.date = date;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean isPermanent() {
		return permanent;
	}
	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Skill getSkills() {
		return skills;
	}
	public void setSkills(Skill skills) {
		this.skills = skills;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
