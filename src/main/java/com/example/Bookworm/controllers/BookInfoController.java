package com.example.Bookworm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bookworm.models.Book;
import com.example.Bookworm.models.BookInfo;
import com.example.Bookworm.services.BookInfoService;

@RestController
public class BookInfoController {
	@Autowired
	private BookInfoService bookInfoService;
	
	@PostMapping("/book-info/add")
	public ResponseEntity<?> addBookInfo(@RequestBody BookInfo bookInfo){
		return bookInfoService.addBookInfo(bookInfo);
	}
	@GetMapping("/book-info/get")
	public ResponseEntity<?> getBookInfo(){
		return bookInfoService.getBookInfo();
	}

	@PostMapping("/add-book/book-info/{id}")
	public ResponseEntity<?> addBookToInfo(@PathVariable(name = "id") Long bookInfoId,
			@RequestBody Book book){
		return bookInfoService.addBookToInfo(bookInfoId, book);
	}
}
