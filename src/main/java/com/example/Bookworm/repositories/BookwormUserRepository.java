package com.example.Bookworm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.Bookworm.models.BookwormUser;

@Repository
public interface BookwormUserRepository extends JpaRepository<BookwormUser, Long>{

}
