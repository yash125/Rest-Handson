package com.cognizant.project.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Skill {
	
	@NotNull
	private int id;
	@NotBlank
	@NotNull
	@Size(min=1,max=30)
	private String name;
	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Skill(int id, String name) {
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
