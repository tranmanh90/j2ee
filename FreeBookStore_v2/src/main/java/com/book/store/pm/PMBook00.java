package com.book.store.pm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.book.store.BookConstant;
import com.book.store.IBasePM;
import com.book.store.common.IBDBookStore;
import com.book.store.common.IIBookStore;
import com.book.store.dto.Author00Dto;
import com.book.store.dto.Book00Dto;
import com.book.store.dto.Book00Request;
import com.book.store.dto.Book00Response;
import com.book.store.dto.Category00Dto;
import com.book.store.vo.Author00VO;
import com.book.store.vo.Book00VO;
import com.book.store.vo.BookAuthor00VO;

/**************************************************************
 * <pre>
* Search book by title process main
 * </pre>
 * 
 * @author TRAN VAN MANH
 * @email tranmanh.vn90@gmail.com
 * @importance
 *************************************************************/
public class PMBook00 implements IBasePM<Book00Request, Book00Response> {

	private String className = getClass().getName();
	private Logger logger = LoggerFactory.getLogger(className);
	private IIBookStore iibt = new IBDBookStore();

	/**************************************************************
	 * <pre>
	* Execute action search
	 * </pre>
	 * 
	 * @param request data object from client
	 * @return Response object
	 *************************************************************/
	@Override
	public Book00Response execute(Book00Request request) {
		Book00Response response = new Book00Response();
		response = searchBookByTitle(request);
		return response;
	}

	private Book00Response searchBookByTitle(Book00Request request) {
		Book00VO inVO = null;
		inVO = toVO(request);
		List<Book00VO> outList = iibt.searchBookByTitle(inVO);
		logger.info("=============> " + outList.toString());
		Book00Response response = toDTO(outList);
		return response;
	}

	private Book00VO toVO(Book00Request request) {
		Book00VO vo = new Book00VO();
		vo.setPage(request.getPage());
		vo.setRowPerPage(request.getRowPerPage());
		vo.setBookTitle(request.getBookTitle());
		return vo;
	}

	private List<Author00Dto> toAuthorDTO(List<Author00VO> inVO) {
		List<Author00Dto> dto = new ArrayList<>();
		Author00Dto row = null;
		for (Author00VO vo : inVO) {
			row = new Author00Dto();
			row.setAuthorId(vo.getAuthorId());
			row.setAuthorName(vo.getAuthorName());
			row.setAuthorAbout(vo.getAuthorAbout());

			dto.add(row);
		}
		return dto;
	}

	private Book00Response toDTO(List<Book00VO> inVO) {
		Book00Response response = new Book00Response();
		List<Book00Dto> listBooks = new ArrayList<>();
		List<Author00Dto> listAuthors = null;
		Book00Dto row = null;
		Category00Dto category = null;

		if (inVO.size() > 0) {
			response.setTotalPages(inVO.get(0).getTotalPages());
			response.setTotalRows(inVO.get(0).getTotalRows());
			response.setPage(inVO.get(0).getPage());
			response.setRspCd(BookConstant.TRN_SUCC);
			response.setRspMsg(BookConstant.TRN_MSG_SUCC);
		} else {
			response.setTotalPages(BookConstant.ZERO_INT);
			response.setTotalRows(BookConstant.ZERO_INT);
			response.setPage(BookConstant.ZERO_INT);
			response.setRspCd(BookConstant.TRN_NOTF);
			response.setRspMsg(BookConstant.TRN_MSG_NOTF);
		}

		for (int i = 0; i < inVO.size(); i++) {
			row = new Book00Dto();
			category = new Category00Dto();
			row.setBookId(inVO.get(i).getBookId());
			row.setBookTitle(inVO.get(i).getBookTitle());
			row.setBookDescription(inVO.get(i).getBookEdition());
			row.setBookPage(inVO.get(i).getBookPage());
			row.setBookFormat(inVO.get(i).getBookFormat());
			row.setBookEdition(inVO.get(i).getBookEdition());
			row.setBookIsbn(inVO.get(i).getBookIsbn());
			row.setPostDate(inVO.get(i).getPostDate());

			// author
			listAuthors = toAuthorDTO(iibt.searchAuthorByBookId(inVO.get(i)));
			row.setAuthors(listAuthors.toArray(new Author00Dto[listAuthors.size()]));

			// category
			category.setCategoryId(inVO.get(i).getCategoryId());
			category.setCategoryName(inVO.get(i).getCategoryName());
			row.setCategory(category);
			
			row.setImageCloud(inVO.get(i).getImageCloud());
			row.setLinkUrl(inVO.get(i).getLinkUrl());

			listBooks.add(row);
		}

		Book00Dto[] arrGrd = listBooks.toArray(new Book00Dto[listBooks.size()]);
		response.setListBooks(arrGrd);
		return response;
	}
}
