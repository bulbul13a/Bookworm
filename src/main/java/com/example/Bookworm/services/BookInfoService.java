package com.example.Bookworm.services;

import org.springframework.http.ResponseEntity;

import com.example.Bookworm.models.Book;
import com.example.Bookworm.models.BookInfo;

public interface BookInfoService {

	ResponseEntity<?> addBookInfo(BookInfo bookInfo);

	ResponseEntity<?> getBookInfo();

	ResponseEntity<?> addBookToInfo(Long bookInfoId, Book book);

}
