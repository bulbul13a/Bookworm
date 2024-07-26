package com.example.Bookworm.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.Bookworm.enums.RequestStatus;
import com.example.Bookworm.models.BookLendingRequest;

public interface BookLendingRequestService {
	ResponseEntity<?> addRequest (BookLendingRequest request);
	ResponseEntity<?> approveRequest(Long id, String approval);
	ResponseEntity<?> returnBook(Long id);
	ResponseEntity<?> getRequests();
	ResponseEntity<?> getRequestsByStatus(List<RequestStatus> requestStatuses);
}
