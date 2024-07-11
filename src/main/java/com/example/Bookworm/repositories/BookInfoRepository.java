package com.example.Bookworm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Bookworm.models.BookInfo;

@Repository
public interface BookInfoRepository extends JpaRepository<BookInfo, Long>{

}