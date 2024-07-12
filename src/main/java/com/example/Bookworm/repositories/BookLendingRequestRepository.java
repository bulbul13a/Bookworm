package com.example.Bookworm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Bookworm.models.BookLendingRequest;

public interface BookLendingRequestRepository extends JpaRepository<BookLendingRequest, Long>{

}