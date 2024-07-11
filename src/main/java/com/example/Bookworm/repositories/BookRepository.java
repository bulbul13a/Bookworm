package com.example.Bookworm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Bookworm.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}