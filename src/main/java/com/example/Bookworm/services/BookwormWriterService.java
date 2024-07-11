package com.example.Bookworm.services;

import org.springframework.http.ResponseEntity;

import com.example.Bookworm.models.BookwormWriter;

public interface BookwormWriterService {
	ResponseEntity<?> add(BookwormWriter bookwormWriter);

	ResponseEntity<?> getAll();

	ResponseEntity<?> delete(Long id);
}
