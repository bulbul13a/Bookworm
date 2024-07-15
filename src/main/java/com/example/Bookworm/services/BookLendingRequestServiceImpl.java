package com.example.Bookworm.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Bookworm.enums.RequestStatus;
import com.example.Bookworm.enums.Status;
import com.example.Bookworm.models.Book;
import com.example.Bookworm.models.BookLendingRequest;
import com.example.Bookworm.models.ResponseMessage;
import com.example.Bookworm.repositories.BookLendingRequestRepository;

@Service
public class BookLendingRequestServiceImpl implements BookLendingRequestService{

	@Value("${max.limit.books}")
	private Long maxBookLimit;
	
	@Autowired
	private BookLendingRequestRepository bookLendingRequestRepository;
	
	@Override
	public ResponseEntity<?> addRequest(BookLendingRequest request) {
		
		request = bookLendingRequestRepository.save(request);
		return ResponseEntity.ok(request);
		
	}

	@Override
	public ResponseEntity<?> approveRequest(Long id, String approval) {
		Optional<BookLendingRequest> optionalRequest = bookLendingRequestRepository.findById(id);
		
		if(optionalRequest.isPresent()){
			if( approval == "APPROVED REQUEST"){
				optionalRequest.get().setReqStatus(RequestStatus.APPROVED);
				Date date = new Date();
				optionalRequest.get().setApprovalDate(date);
			
				for(Book book: optionalRequest.get().getBooks()){
						book.setStatus(Status.UNAVAILABLE);
				}
				
				bookLendingRequestRepository.save(optionalRequest.get());
				
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("APPROVED REQUEST"));
		    }
			else {
				optionalRequest.get().setReqStatus(RequestStatus.REJECTED);
				
				bookLendingRequestRepository.save(optionalRequest.get());
				
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("REJECTED REQUEST"));
			}
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ResponseMessage("Request Not Found"));

		}
	}

	@Override
	public ResponseEntity<?> returnDate(Long id) {
		
		Optional<BookLendingRequest> optionalRequest = bookLendingRequestRepository.findById(id);
		
		
		if(optionalRequest.isPresent()){
			Date date = new Date();
			optionalRequest.get().setReturnDate(date);
			
			for(Book book: optionalRequest.get().getBooks()){
						book.setStatus(Status.AVAILABLE);
			}
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ResponseMessage("Request Not Found"));

		}
		bookLendingRequestRepository.save(optionalRequest.get());
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("Book Returned"));

	}
	
}
