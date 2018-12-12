package com.book.store.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
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
public class AuthorRESTController {
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
	
	// Search book by author
	// http://54.145.176.109/freebookstore/api/v1/search?input-text={inputText}
	@RequestMapping(value = "/freebookstore/api/v1/search-by-author={inputText}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public BookDetails searchBookByAuthor(@PathVariable("inputText") String inputText) {
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
}
