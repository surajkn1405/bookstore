package com.suraj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suraj.entity.Book;

@Repository
public interface bookRepository extends JpaRepository<Book, Integer>{

}
