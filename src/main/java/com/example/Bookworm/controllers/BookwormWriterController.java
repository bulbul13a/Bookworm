package com.example.Bookworm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bookworm.models.BookwormWriter;
import com.example.Bookworm.services.BookwormWriterService;

@RestController
@RequestMapping("/bookworm-writer")

public class BookwormWriterController {
	@Autowired
	private BookwormWriterService bookwormWriterService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addBookwormUser(@RequestBody BookwormWriter bookwormWriter) {
		return bookwormWriterService.add(bookwormWriter);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		return bookwormWriterService.getAll();
	}
	
	@DeleteMapping("/delete/{id}") 
	 public ResponseEntity<?> deleteUser(@PathVariable(name = "id") Long id) { 
	        // Delete the user in this method with the id.
		return bookwormWriterService.delete(id);
	 }
}
