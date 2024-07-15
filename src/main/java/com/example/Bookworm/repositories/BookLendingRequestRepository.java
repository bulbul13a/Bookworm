package com.example.Bookworm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Bookworm.models.BookLendingRequest;

@Repository
public interface BookLendingRequestRepository extends JpaRepository<BookLendingRequest, Long>{

}