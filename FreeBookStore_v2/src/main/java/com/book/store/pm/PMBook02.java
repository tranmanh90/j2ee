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
import com.book.store.dto.Author02Dto;
import com.book.store.dto.Book02Dto;
import com.book.store.dto.Book02Request;
import com.book.store.dto.Book02Response;
import com.book.store.vo.Book02VO;

/**************************************************************
 * <pre>
* Search book by author process main
 * </pre>
 * 
 * @author TRAN VAN MANH
 * @email tranmanh.vn90@gmail.com
 * @importance
 *************************************************************/
public class PMBook02 implements IBasePM<Book02Request, Book02Response> {

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
	public Book02Response execute(Book02Request request) {
		Book02Response response = new Book02Response();
		logger.info("BookRequest PM: " + request.toString());
		response = searchBookByAuthor(request);
		return response;
	}

	private Book02Response searchBookByAuthor(Book02Request request) {
		Book02VO inVO = null;
		inVO = toVO(request);
		logger.info("inVO PM: " + inVO.toString());
		List<Book02VO> outList = iibt.searchBookByAuthor(inVO);
		Book02Response response = toDTO(outList);
		return response;
	}

	private Book02VO toVO(Book02Request request) {
		Book02VO vo = new Book02VO();
		vo.setPage(request.getPage());
		vo.setRowPerPage(request.getRowPerPage());
		vo.setAuthorId(request.getAuthorId());
		return vo;
	}

	private Book02Response toDTO(List<Book02VO> inVO) {
		logger.info("toDTO: " + inVO.toString());
		Book02Response response = new Book02Response();
		List<Book02Dto> listBooks = new ArrayList<>();
		Map<String, Integer> mapBookId = new HashMap<String, Integer>();
		List<Author02Dto> listAuthors = null;
		Book02Dto row = null;
		Author02Dto author = null;
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

		for (Book02VO vo : inVO) {
			Integer cnt = mapBookId.get(vo.getBookId());
			mapBookId.put(vo.getBookId(), (cnt == null) ? 1 : ++cnt);
		}

		for (Map.Entry<String, Integer> entry : mapBookId.entrySet()) {
			row = new Book02Dto();
			key = entry.getKey();
			value = entry.getValue();
			response.setTotalRows(inVO.get(0).getTotalRows() - value + 1);

			if (value >= 2) {
				listAuthors = new ArrayList<>();
				for (int i = 0; i < inVO.size(); i++) {
					if (inVO.get(i).getBookId().equals(key)) {
						author = new Author02Dto();
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
				row.setAuthors(listAuthors.toArray(new Author02Dto[listAuthors.size()]));
				listBooks.add(row);
			} else {
				listAuthors = new ArrayList<>();
				for (int i = 0; i < inVO.size(); i++) {
					if (inVO.get(i).getBookId().equals(key)) {
						author = new Author02Dto();
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
				row.setAuthors(listAuthors.toArray(new Author02Dto[listAuthors.size()]));
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

		Book02Dto[] arrGrd = listBooks.toArray(new Book02Dto[listBooks.size()]);
		response.setListBooks(arrGrd);
		return response;
	}
}
