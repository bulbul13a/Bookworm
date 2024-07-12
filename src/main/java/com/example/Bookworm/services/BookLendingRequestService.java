package com.example.Bookworm.services;

import org.springframework.http.ResponseEntity;

import com.example.Bookworm.models.BookLendingRequest;

public interface BookLendingRequestService {
	ResponseEntity<?> addRequest (BookLendingRequest request);
	ResponseEntity<?> approveRequest();
	ResponseEntity<?> returnDate();
}
