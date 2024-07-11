package com.example.Bookworm.services;

import org.springframework.http.ResponseEntity;

public interface BookService {

	ResponseEntity<?> toggleStatus( Long id);
}