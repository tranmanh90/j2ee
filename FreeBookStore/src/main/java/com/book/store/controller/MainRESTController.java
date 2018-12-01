package com.book.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.dao.BookDAO;
import com.book.store.model.Book;

@RestController
public class MainRESTController {
	@Autowired
	private BookDAO bookDAO;

	// Welcome page
	// http://54.145.176.109/
	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "Welcome to Free Book Store web service !!!";
	}

	// Get list books
	// http://54.145.176.109/freebookstore/api/v1/get-list-books
	@RequestMapping(value = "/freebookstore/api/v1/get-list-books", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<Book> getBooks() {
		return bookDAO.getBooks();
	}

	// Get a book
	// http://54.145.176.109/freebookstore/api/v1/search-by-book-id={bookId}
	@RequestMapping(value = "/freebookstore/api/v1/search-by-book-id={bookId}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Book getBook(@PathVariable("bookId") String bookId) {
		return bookDAO.getBook(bookId);
	}

	// Insert a book
	// http://54.145.176.109/freebookstore/api/v1/insert-a-book
	@RequestMapping(value = "/freebookstore/api/v1/insert-a-book", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<Book> createEmployee(@RequestBody Book book) {
		System.out.println("(Service Side) Creating book: " + book.getBookId());
		return bookDAO.createBook(book);
	}

	// Update a book
	// http://54.145.176.109/freebookstore/api/v1/update-a-book
	@RequestMapping(value = "/freebookstore/api/v1/update-a-book", //
			method = RequestMethod.PUT, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<Book> updateEmployee(@RequestBody Book book) {
		System.out.println("(Service Side) Editing employee: " + book.getBookId());
		return bookDAO.updateBook(book);
	}

	// Delete a book
	// http://54.145.176.109/freebookstore/api/v1/delete/book-id={bookId}
	@RequestMapping(value = "/freebookstore/api/v1/delete/book-id={bookId}", //
			method = RequestMethod.DELETE, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<Book> deleteBook(@PathVariable("bookId") String bookId) {
		System.out.println("(Service Side) Deleting employee: " + bookId);
		return bookDAO.deleteBook(bookId);
	}

}
