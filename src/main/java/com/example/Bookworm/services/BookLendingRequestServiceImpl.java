package com.example.Bookworm.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Bookworm.models.BookLendingRequest;

@Service
public class BookLendingRequestServiceImpl implements BookLendingRequestService{

	@Override
	public ResponseEntity<?> addRequest(BookLendingRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> approveRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> returnDate() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
