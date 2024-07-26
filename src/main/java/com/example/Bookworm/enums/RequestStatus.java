package com.example.Bookworm.enums;

public enum RequestStatus {
	REJECTED("REJECTED"), APPROVED("APPROVED"), PENDING("PENDING");
	
	private String value;

	public String getValue() {
		return value;
	}

	private RequestStatus(String value) {
		this.value = value;
	}
	
}