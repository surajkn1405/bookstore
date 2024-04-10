package com.suraj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suraj.entity.Book;
import com.suraj.repository.bookRepository;

@Service
public class BookService {
	
	@Autowired
	private bookRepository bookRepository;
	
	public void save(Book b) {
		bookRepository.save(b);
	}
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	public Book getBookById(int id) {
		return bookRepository.findById(id).get();
	}
	
	public void deleteById(int id) {
		bookRepository.deleteById(id);
	}
}
