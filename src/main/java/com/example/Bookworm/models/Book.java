package com.example.Bookworm.models;

import java.util.Objects;

import com.example.Bookworm.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Book extends Root{
	@ManyToOne
	private BookwormUser owner;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public BookwormUser getOwner() {
		return owner;
	}
	public void setOwner(BookwormUser owner) {
		this.owner = owner;
	}
	public Status getStatus() {
		return Objects.isNull(status)?Status.AVAILABLE : status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
