package com.example.Bookworm.services;

import org.springframework.http.ResponseEntity;

import com.example.Bookworm.models.BookwormUser;

public interface BookwormUserService {

	ResponseEntity<?> add(BookwormUser bookwormUser);

	ResponseEntity<?> getAll();

	ResponseEntity<?> update(Long id, BookwormUser bookwormUser);

	ResponseEntity<?> delete(Long id);

}
