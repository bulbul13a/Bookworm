package com.example.Bookworm.models;

import jakarta.persistence.Entity;

@Entity
public class Writer extends Root{
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
