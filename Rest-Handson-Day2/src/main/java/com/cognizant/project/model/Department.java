package com.cognizant.project.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Department {
	
	@NotNull
	private int id;
	@NotNull
	@NotBlank
	@Size(min=1, max=30)
	private String name;
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	

}
