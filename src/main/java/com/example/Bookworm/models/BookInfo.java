package com.example.Bookworm.models;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class BookInfo extends Root{
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_info_id", referencedColumnName = "id")
	private List<Book> books;
	
	@ManyToOne
	private Writer writer;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Writer getWriter() {
		return writer;
	}
	public void setWriter(Writer writer) {
		this.writer = writer;
	}
	public List<Book>getBooks(){
		return Objects.isNull(books)? new ArrayList<>() : books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
