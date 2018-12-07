package com.book.store.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.constant.BTConstants;
import com.book.store.dao.AuthorDAO;
import com.book.store.dao.BookAuthorDAO;
import com.book.store.dao.BookCategoryDAO;
import com.book.store.dao.BookCoverDAO;
import com.book.store.dao.BookDAO;
import com.book.store.dao.BookImageUrlDAO;
import com.book.store.dao.BookLinkDAO;
import com.book.store.dao.CategoryDAO;
import com.book.store.dao.DownloadLinkDAO;
import com.book.store.model.Author;
import com.book.store.model.Book;
import com.book.store.model.BookAuthor;
import com.book.store.model.BookCategory;
import com.book.store.model.BookCover;
import com.book.store.model.BookDetails;
import com.book.store.model.BookImageUrl;
import com.book.store.model.BookLink;
import com.book.store.model.Category;
import com.book.store.model.DownloadLink;

@RestController
public class MainRESTController {

	// Book
	@Autowired
	private BookDAO bookDAO;

	// Book author
	@Autowired
	private AuthorDAO authorDAO;
	@Autowired
	private BookAuthorDAO bookAuthorDAO;

	// Category
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private BookCategoryDAO bookCategoryDAO;

	// Cover image
	@Autowired
	private BookCoverDAO bookCoverDAO;
	@Autowired
	private BookImageUrlDAO bookImageUrlDAO;

	// Download link
	@Autowired
	private DownloadLinkDAO downloadLinkDAO;
	@Autowired
	private BookLinkDAO bookLinkDAO;

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
	public BookDetails getBooks() {
		Author author;
		BookCover bookCover;
		BookImageUrl bookImageUrl;
		BookCategory bookCategory;
		Category category;
		BookLink bookLink;
		DownloadLink downloadLink;

		List<Author> authors;
		List<BookAuthor> bookAuthors = new ArrayList<>();
		List<Book> listBooks = new ArrayList<>();
		listBooks = bookDAO.getListBooks(); // lấy được dánh sách các book có từ tương tự inputtext
		if (listBooks != null && listBooks.size() != 0) {
			for (int i = 0; i < listBooks.size(); i++) {
				authors = new ArrayList<>();
				// lấy ra danh sách các authorId có cùng bookId
				bookAuthors = bookAuthorDAO.getBookAuthors(listBooks.get(i).getBookId());

				// lấy ra imageId tương ứng bookId truyền vào
				bookCover = bookCoverDAO.getBookCover(listBooks.get(i).getBookId());
				bookImageUrl = bookImageUrlDAO.getBookImageCloudUrl(bookCover != null ? bookCover.getImageId() : null);
				listBooks.get(i).setCoverImage(bookImageUrl);

				// lấy ra categoryID tương ứng bookId truyền vào
				bookCategory = bookCategoryDAO.getBookCategory(listBooks.get(i).getBookId());
				category = categoryDAO.getCategory(bookCategory != null ? bookCategory.getCategoryId() : null);
				listBooks.get(i).setCategory(category);

				// lấy ra linkId tương ứng với bookId truyền vào
				bookLink = bookLinkDAO.getBookLink(listBooks.get(i).getBookId());
				downloadLink = downloadLinkDAO.getDownloadLink(bookLink != null ? bookLink.getLinkId() : null);
				listBooks.get(i).setDownloadLink(downloadLink);

				for (int j = 0; j < bookAuthors.size(); j++) {
					author = new Author();
					author = authorDAO.getAuthor(bookAuthors.get(j).getAuthorId()); // get author by author id
					authors.add(author); // lấy ra danh sách các author ứng với cuốn sách đó
				}
				listBooks.get(i).setAuthors(authors);
			}
		} else {
			return new BookDetails(BTConstants.RESPONSE.TRN_NOTF, BTConstants.RESPONSE.TRN_MSG_NOTF);
		}
		return new BookDetails(listBooks, BTConstants.RESPONSE.TRN_SUCC, BTConstants.RESPONSE.TRN_MSG_SUCC);
	}

	// Search by text
	// http://54.145.176.109/freebookstore/api/v1/search?input-text={inputText}
	@RequestMapping(value = "/freebookstore/api/v1/search-by-text={inputText}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public BookDetails searchBookByText(@PathVariable("inputText") String inputText) {
		Author author;
		BookCover bookCover;
		BookCategory bookCategory;
		Category category;
		BookImageUrl bookImageUrl;
		BookLink bookLink;
		DownloadLink downloadLink;
		List<Author> listAuthors;
		List<BookAuthor> listBookAuthors = new ArrayList<>();
		List<Book> listBooks = new ArrayList<>();
		// lấy được danh sách book có từ tương tự inputtext
		listBooks = bookDAO.searchBookByText(inputText);
		if (listBooks != null && listBooks.size() != 0) {
			for (int i = 0; i < listBooks.size(); i++) {
				listAuthors = new ArrayList<>();
				// lấy ra danh sách các authorId có cùng bookId
				listBookAuthors = bookAuthorDAO.getBookAuthors(listBooks.get(i).getBookId());

				// lấy ra imageId tương ứng bookId truyền vào
				bookCover = bookCoverDAO.getBookCover(listBooks.get(i).getBookId());
				bookImageUrl = bookImageUrlDAO.getBookImageCloudUrl(bookCover != null ? bookCover.getImageId() : null);
				listBooks.get(i).setCoverImage(bookImageUrl);

				// lấy ra categoryID tương ứng bookId truyền vào
				bookCategory = bookCategoryDAO.getBookCategory(listBooks.get(i).getBookId());
				category = categoryDAO.getCategory(bookCategory != null ? bookCategory.getCategoryId() : null);
				listBooks.get(i).setCategory(category);

				// lấy ra linkId tương ứng với bookId truyền vào
				bookLink = bookLinkDAO.getBookLink(listBooks.get(i).getBookId());
				downloadLink = downloadLinkDAO.getDownloadLink(bookLink != null ? bookLink.getLinkId() : null);
				listBooks.get(i).setDownloadLink(downloadLink);

				for (int j = 0; j < listBookAuthors.size(); j++) {
					author = new Author();
					author = authorDAO.getAuthor(listBookAuthors.get(j).getAuthorId()); // get author by author id
					listAuthors.add(author); // lấy ra danh sách các author ứng với cuốn sách đó
				}
				listBooks.get(i).setAuthors(listAuthors);
			}
		} else {
			return new BookDetails(BTConstants.RESPONSE.TRN_NOTF, BTConstants.RESPONSE.TRN_MSG_NOTF);
		}
		return new BookDetails(listBooks, BTConstants.RESPONSE.TRN_SUCC, BTConstants.RESPONSE.TRN_MSG_SUCC);
	}

	// Get a book by ID
	// http://54.145.176.109/freebookstore/api/v1/search?book-id={bookId}
	@RequestMapping(value = "/freebookstore/api/v1/search-by-book-id={bookId}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public BookDetails getBook(@PathVariable("bookId") String bookId) {
		Author author;
		List<Author> authors;
		List<BookAuthor> bookAuthors = new ArrayList<>();
		List<Book> books = new ArrayList<>();

		books = bookDAO.getBook(bookId); // lấy được dánh sách các book có từ tương tự inputtext
		if (books != null && books.size() != 0) {
			for (int i = 0; i < books.size(); i++) {
				authors = new ArrayList<>();
				bookAuthors = bookAuthorDAO.getBookAuthors(books.get(i).getBookId());// lấy ra list authorId cùng bookId
				for (int j = 0; j < bookAuthors.size(); j++) {
					author = new Author();
					author = authorDAO.getAuthor(bookAuthors.get(j).getAuthorId()); // get author by author id
					authors.add(author); // lấy ra danh sách các author ứng với cuốn sách đó
				}
				books.get(i).setAuthors(authors);
			}
		} else {
			return new BookDetails(BTConstants.RESPONSE.TRN_NOTF, BTConstants.RESPONSE.TRN_MSG_NOTF);
		}

		return new BookDetails(books, BTConstants.RESPONSE.TRN_SUCC, BTConstants.RESPONSE.TRN_MSG_SUCC);
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
