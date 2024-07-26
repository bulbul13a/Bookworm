package com.example.Bookworm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Bookworm.enums.RequestStatus;
import com.example.Bookworm.models.BookLendingRequest;

@Repository
public interface BookLendingRequestRepository extends JpaRepository<BookLendingRequest, Long>{
	List<BookLendingRequest> findByRequestStatus(List<RequestStatus> requestStatuses);
}