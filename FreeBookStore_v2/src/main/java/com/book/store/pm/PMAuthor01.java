package com.book.store.pm;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.book.store.BookConstant;
import com.book.store.IBasePM;
import com.book.store.common.IBDBookStore;
import com.book.store.common.IIBookStore;
import com.book.store.dto.Author01Dto;
import com.book.store.dto.Author01Request;
import com.book.store.dto.Author01Response;
import com.book.store.vo.Author00VO;

/**************************************************************
 * <pre>
* Author process main
 * </pre>
 * 
 * @author TRAN VAN MANH
 * @email tranmanh.vn90@gmail.com
 * @importance
 *************************************************************/
public class PMAuthor01 implements IBasePM<Author01Request, Author01Response> {

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
	public Author01Response execute(Author01Request request) {
		Author01Response response = new Author01Response();
		response = searchAuthorById(request);
		return response;
	}

	private Author01Response searchAuthorById(Author01Request request) {
		Author00VO inVO = null;
		inVO = toVO(request);
		List<Author00VO> outList = iibt.searchAuthorById(inVO);
		Author01Response response = toDTO(outList);
		return response;
	}

	private Author00VO toVO(Author01Request request) {
		Author00VO vo = new Author00VO();
		vo.setPage(request.getPage());
		vo.setRowPerPage(request.getRowPerPage());
		vo.setAuthorId(request.getAuthorId());
		return vo;
	}

	private Author01Response toDTO(List<Author00VO> inVO) {
		Author01Response response = new Author01Response();
		List<Author01Dto> listAuthors = new ArrayList<>();
		Author01Dto row = null;

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

		for (Author00VO vo : inVO) {
			row = new Author01Dto();
			row.setAuthorId(vo.getAuthorId());
			row.setAuthorName(vo.getAuthorName());
			row.setAuthorAbout(vo.getAuthorAbout());
			listAuthors.add(row);
		}

		Author01Dto[] arrGrd = listAuthors.toArray(new Author01Dto[listAuthors.size()]);
		response.setAuthor(arrGrd);
		return response;
	}

}
