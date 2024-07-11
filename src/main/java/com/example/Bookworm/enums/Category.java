package com.example.Bookworm.enums;

public enum Category {
	
	FICTION("Fiction"), THRILLER("Thriller"), NOVEL("Novel");
	
	private String value;
	
	public String getValue() {
		return value;
	}
	
	private Category(String value) {
		this.value = value;
	}
}
