package com.eadydb.boot.entity;

import lombok.Data;

@Data
public class TaskRepresentation {

	
	private String id;
	
	private String name;

	
	
	public TaskRepresentation(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	public TaskRepresentation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
