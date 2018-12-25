package com.book.store.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PMBook implements IBasePM<BookRequest, BookResponse> {
	
	private Dbook dBook = new Dbook();
	
	@Override
	public BookResponse execute(BookRequest request) {
		BookResponse response = new BookResponse();
		response = retrieveBookDetails(request);
		return response;
	}

	private BookResponse retrieveBookDetails(BookRequest request) {
		System.out.println("request PM: " + request);
		Book00VO inVO = null;
		inVO = toVO(request);
		System.out.println("inVO PM: " + inVO);
		System.out.println("dBook PM: " + dBook);
		List<Book00VO> outList = dBook.s000(inVO);
		BookResponse response = toDTO(outList);
		return response;
	}

	private Book00VO toVO(BookRequest request) {
		Book00VO vo = new Book00VO();
		vo.setBookId(request.getBookId());
		return vo;
	}

	private BookResponse toDTO(List<Book00VO> inVO) {
		BookResponse response = new BookResponse();
		List<BookDto> grdList = new ArrayList<>();
		BookDto grdRow = null;

		for (Book00VO vo : inVO) {
			grdRow = new BookDto();
			grdRow.setBookId(vo.getBookId());
			grdRow.setBookTitle(vo.getBookTitle());
			grdRow.setBookDescription(vo.getBookEdition());
			grdRow.setBookPage(vo.getBookPage());
			grdRow.setBookFormat(vo.getBookFormat());
			grdRow.setBookEdition(vo.getBookEdition());
			grdRow.setBookIsbn(vo.getBookIsbn());
			grdRow.setPostDate(vo.getPostDate());
			grdRow.setAuthorId(vo.getAuthorId());
			grdRow.setAuthorName(vo.getAuthorName());
			grdRow.setAuthorAbout(vo.getAuthorAbout());
			grdRow.setImageCloud(vo.getImageCloud());
			grdRow.setCategoryId(vo.getCategoryId());
			grdRow.setLinkUrl(vo.getLinkUrl());

			grdList.add(grdRow);
		}

		BookDto[] arrGrd = grdList.toArray(new BookDto[grdList.size()]);
		response.setGrdList(arrGrd);
		return response;
	}
}
