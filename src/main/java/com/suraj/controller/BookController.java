package com.suraj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.suraj.entity.Book;
import com.suraj.entity.MyBookList;
import com.suraj.service.BookService;
import com.suraj.service.MyBookListService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private MyBookListService bookListService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
		public String bookRegister() {
			return "bookRegister";
		}
	
	@GetMapping("/available_book")
	public ModelAndView getAllBooks() {
		List<Book> list = bookService.getAllBooks();
		return new ModelAndView("bookList", "book",list);
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		bookService.save(b);
		return "redirect:/available_book";
	}
	
	
	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBookList> list = bookListService.getAllBooks();
		model.addAttribute("book",list);
		return "myBooks";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book book = bookService.getBookById(id);
		MyBookList mb = new MyBookList(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
		bookListService.saveMyBooks(mb);
		return "redirect:/my_books";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		Book book = bookService.getBookById(id);
		model.addAttribute("book",book);
		return "bookEdit";
	}
	
	
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		bookService.deleteById(id);
		return "redirect:/available_book";
	}
	
}
