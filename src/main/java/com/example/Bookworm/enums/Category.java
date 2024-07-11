package com.example.Bookworm.enums;

public enum Category {
	
	FICTION("Fiction"),
	SCIENCE("Science"),
	NOVEL("Novel"),
	FANTASY("Fantasy");
	
	private String value;
	
	public String getValue() {
		return value;
	}
	
	private Category(String value) {
		this.value = value;
	}
}
