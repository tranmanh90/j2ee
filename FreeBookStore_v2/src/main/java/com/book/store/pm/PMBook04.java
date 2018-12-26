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
import com.book.store.dto.Author04Dto;
import com.book.store.dto.Book04Dto;
import com.book.store.dto.Book04Request;
import com.book.store.dto.Book04Response;
import com.book.store.vo.Book04VO;

/**************************************************************
 * <pre>
* Search book by containing words process main
 * </pre>
 * 
 * @author TRAN VAN MANH
 * @email tranmanh.vn90@gmail.com
 * @importance
 *************************************************************/
public class PMBook04 implements IBasePM<Book04Request, Book04Response> {

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
	public Book04Response execute(Book04Request request) {
		Book04Response response = new Book04Response();
		response = searchBookByContainingWords(request);
		return response;
	}

	private Book04Response searchBookByContainingWords(Book04Request request) {
		Book04VO inVO = null;
		inVO = toVO(request);
		List<Book04VO> outList = iibt.searchBookByContainingWords(inVO);
		Book04Response response = toDTO(outList);
		return response;
	}

	private Book04VO toVO(Book04Request request) {
		Book04VO vo = new Book04VO();
		vo.setPage(request.getPage());
		vo.setRowPerPage(request.getRowPerPage());
		vo.setBookTitle(request.getContainingWords());
		vo.setBookDescription(request.getContainingWords());
		return vo;
	}

	private Book04Response toDTO(List<Book04VO> inVO) {
		logger.info("toDTO: " + inVO.toString());
		Book04Response response = new Book04Response();
		List<Book04Dto> listBooks = new ArrayList<>();
		Map<String, Integer> mapBookId = new HashMap<String, Integer>();
		List<Author04Dto> listAuthors = null;
		Book04Dto row = null;
		Author04Dto author = null;
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

		for (Book04VO vo : inVO) {
			Integer cnt = mapBookId.get(vo.getBookId());
			mapBookId.put(vo.getBookId(), (cnt == null) ? 1 : ++cnt);
		}

		for (Map.Entry<String, Integer> entry : mapBookId.entrySet()) {
			row = new Book04Dto();
			key = entry.getKey();
			value = entry.getValue();
			response.setTotalRows(inVO.get(0).getTotalRows() - value + 1);

			if (value >= 2) {
				listAuthors = new ArrayList<>();
				for (int i = 0; i < inVO.size(); i++) {
					if (inVO.get(i).getBookId().equals(key)) {
						author = new Author04Dto();
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
				row.setAuthors(listAuthors.toArray(new Author04Dto[listAuthors.size()]));
				listBooks.add(row);
			} else {
				listAuthors = new ArrayList<>();
				for (int i = 0; i < inVO.size(); i++) {
					if (inVO.get(i).getBookId().equals(key)) {
						author = new Author04Dto();
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
				row.setAuthors(listAuthors.toArray(new Author04Dto[listAuthors.size()]));
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

		Book04Dto[] arrGrd = listBooks.toArray(new Book04Dto[listBooks.size()]);
		response.setListBooks(arrGrd);
		return response;
	}
}
