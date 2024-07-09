package com.example.Bookworm.services;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Bookworm.models.BookwormWriter;
import com.example.Bookworm.models.ResponseMessage;
import com.example.Bookworm.repositories.BookwormWriterRepository;

@Service
public class BookwormWriterServiceImpl implements BookwormWriterService{
	@Autowired
	private BookwormWriterRepository bookwormWriterRepository;

	@Override
	public ResponseEntity<?> add(BookwormWriter bookwormWriter) {
		if(Objects.isNull(bookwormWriter.getName()) || bookwormWriter.getName().trim().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid name"));
		}
		return ResponseEntity.ok(bookwormWriterRepository.save(bookwormWriter));
	}

	@Override
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(bookwormWriterRepository.findAll());
	}

	@Override
	public ResponseEntity<?> update(Long id, BookwormWriter bookwormWriter) {
		Optional<BookwormWriter> optionalExistingBW = bookwormWriterRepository.findById(id);
		if(optionalExistingBW.isPresent()) {
			optionalExistingBW.get().setCategory(bookwormWriter.getCategory().trim());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Not Found"));
	}
	
	@Override
	public ResponseEntity<?> delete(Long id) {
		Optional<BookwormWriter> optionalExistingBW = bookwormWriterRepository.findById(id);
		if(optionalExistingBW.isPresent()) {
			bookwormWriterRepository.deleteById(id);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Element deleted"));
	}
}
