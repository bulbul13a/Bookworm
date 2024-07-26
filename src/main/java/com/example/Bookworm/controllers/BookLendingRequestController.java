package com.example.Bookworm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bookworm.enums.RequestStatus;
import com.example.Bookworm.models.BookLendingRequest;
import com.example.Bookworm.services.BookLendingRequestService;

@RestController
@RequestMapping("/lend-request")
public class BookLendingRequestController {
	@Autowired BookLendingRequestService bookLendingRequestService;
	
	@PostMapping("/add-request")
	public ResponseEntity<?> addRequest(@RequestBody BookLendingRequest request){
		return bookLendingRequestService.addRequest(request);
	}
	@PutMapping("/approve-request/{id}/{approval}")
	public ResponseEntity<?> approveRequest(@PathVariable(name = "id") Long id,@PathVariable(name = "approval") String approval){
		return bookLendingRequestService.approveRequest(id, approval);
	}
	@PutMapping("/return-request/{id}")
	public ResponseEntity<?> returnBook(@PathVariable(name = "id") Long id){
		return bookLendingRequestService.returnBook(id);
	}
	@GetMapping("/get-all/{id}")
	public ResponseEntity<?> getRequests(){
		return bookLendingRequestService.getRequests();
	}
	
	@GetMapping("/get-status/{status}")
	public ResponseEntity<?> getRequestByStatus(@PathVariable(name = "status") List<RequestStatus> status){
		return bookLendingRequestService.getRequestsByStatus(status);
	}
}
