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
import com.book.store.dto.Author03Dto;
import com.book.store.dto.Book03Dto;
import com.book.store.dto.Book03Request;
import com.book.store.dto.Book03Response;
import com.book.store.vo.Book03VO;

/**************************************************************
 * <pre>
* Search book by category id process main
 * </pre>
 * 
 * @author TRAN VAN MANH
 * @email tranmanh.vn90@gmail.com
 * @importance
 *************************************************************/
public class PMBook03 implements IBasePM<Book03Request, Book03Response> {

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
	public Book03Response execute(Book03Request request) {
		Book03Response response = new Book03Response();
		logger.info("BookRequest PM: " + request.toString());
		response = searchBookByAuthor(request);
		return response;
	}

	private Book03Response searchBookByAuthor(Book03Request request) {
		Book03VO inVO = null;
		inVO = toVO(request);
		logger.info("inVO PM: " + inVO.toString());
		List<Book03VO> outList = iibt.searchBookByCategory(inVO);
		Book03Response response = toDTO(outList);
		return response;
	}

	private Book03VO toVO(Book03Request request) {
		Book03VO vo = new Book03VO();
		vo.setPage(request.getPage());
		vo.setRowPerPage(request.getRowPerPage());
		vo.setCategoryId(request.getCategoryId());
		return vo;
	}

	private Book03Response toDTO(List<Book03VO> inVO) {
		logger.info("toDTO: " + inVO.toString());
		Book03Response response = new Book03Response();
		List<Book03Dto> listBooks = new ArrayList<>();
		Map<String, Integer> mapBookId = new HashMap<String, Integer>();
		List<Author03Dto> listAuthors = null;
		Book03Dto row = null;
		Author03Dto author = null;
		String key;
		int value;

		if (inVO.size() > 0) {
			response.setTotalPages(inVO.get(0).getTotalPages());
//			response.setTotalRows(inVO.get(0).getTotalRows());
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

		for (Book03VO vo : inVO) {
			Integer cnt = mapBookId.get(vo.getBookId());
			mapBookId.put(vo.getBookId(), (cnt == null) ? 1 : ++cnt);
		}

		for (Map.Entry<String, Integer> entry : mapBookId.entrySet()) {
			row = new Book03Dto();
			key = entry.getKey();
			value = entry.getValue();
			response.setTotalRows(inVO.get(0).getTotalRows() - value + 1);

			if (value >= 2) {
				listAuthors = new ArrayList<>();
				for (int i = 0; i < inVO.size(); i++) {
					if (inVO.get(i).getBookId().equals(key)) {
						author = new Author03Dto();
						row.setBookId(key);
						row.setBookTitle(inVO.get(i).getBookTitle());
						row.setBookDescription(inVO.get(i).getBookDescription());
						row.setBookPage(inVO.get(i).getBookPage());
						row.setBookFormat(inVO.get(i).getBookFormat());
						row.setBookEdition(inVO.get(i).getBookEdition());
						row.setBookIsbn(inVO.get(i).getBookIsbn());
						row.setPostDate(inVO.get(i).getPostDate());
						author.setAuthorId(inVO.get(i).getAuthorId());
						author.setAuthorName(inVO.get(i).getAuthorName());
						author.setAuthorAbout(inVO.get(i).getAuthorAbout());
						row.setImageCloud(inVO.get(i).getImageCloud());
						row.setCategoryId(inVO.get(i).getCategoryId());
						row.setLinkUrl(inVO.get(i).getLinkUrl());
						listAuthors.add(author);

					}
				}
				row.setAuthors(listAuthors.toArray(new Author03Dto[listAuthors.size()]));
				listBooks.add(row);
			} else {
				listAuthors = new ArrayList<>();
				for (int i = 0; i < inVO.size(); i++) {
					if (inVO.get(i).getBookId().equals(key)) {
						author = new Author03Dto();
						row.setBookId(key);
						row.setBookTitle(inVO.get(i).getBookTitle());
						row.setBookDescription(inVO.get(i).getBookDescription());
						row.setBookPage(inVO.get(i).getBookPage());
						row.setBookFormat(inVO.get(i).getBookFormat());
						row.setBookEdition(inVO.get(i).getBookEdition());
						row.setBookIsbn(inVO.get(i).getBookIsbn());
						row.setPostDate(inVO.get(i).getPostDate());
						author.setAuthorId(inVO.get(i).getAuthorId());
						author.setAuthorName(inVO.get(i).getAuthorName());
						author.setAuthorAbout(inVO.get(i).getAuthorAbout());
						row.setImageCloud(inVO.get(i).getImageCloud());
						row.setCategoryId(inVO.get(i).getCategoryId());
						row.setLinkUrl(inVO.get(i).getLinkUrl());
						listAuthors.add(author);
					}
				}
				row.setAuthors(listAuthors.toArray(new Author03Dto[listAuthors.size()]));
				listBooks.add(row);
			}
		}

//		for (Book00VO vo : inVO) {
//			row = new Book00Dto();
//			row.setBookId(vo.getBookId());
//			row.setBookTitle(vo.getBookTitle());
//			row.setBookDescription(vo.getBookEdition());
//			row.setBookPage(vo.getBookPage());
//			row.setBookFormat(vo.getBookFormat());
//			row.setBookEdition(vo.getBookEdition());
//			row.setBookIsbn(vo.getBookIsbn());
//			row.setPostDate(vo.getPostDate());
//			
//			row.setImageCloud(vo.getImageCloud());
//			row.setCategoryId(vo.getCategoryId());
//			row.setLinkUrl(vo.getLinkUrl());
//
//			listBooks.add(row);
//		}

		Book03Dto[] arrGrd = listBooks.toArray(new Book03Dto[listBooks.size()]);
		response.setListBooks(arrGrd);
		return response;
	}
}
