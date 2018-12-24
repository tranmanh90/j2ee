package com.book.store.bf;

import java.util.List;

import com.book.store.df.Dauthor;
import com.book.store.vo.Author00VO;

public class SearchAuthorByName {

	private Dauthor df = null;

	public List<Author00VO> execute(Author00VO vo) {
		List<Author00VO> returnList = null;
		if (df == null) {
			df = new Dauthor();
		}
		returnList = df.s000(vo);
		return returnList;
	}
}
