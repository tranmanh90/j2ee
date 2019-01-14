package com.book.store.bf;

import java.util.List;

import com.book.store.df.Dauthor;
import com.book.store.df.Dcategory;
import com.book.store.vo.Author00VO;
import com.book.store.vo.Category00VO;

public class SearchCategoryById {
	private Dcategory df = null;

	/**************************************************************
	 * <pre>
	 * Execute query author by id
	 * </pre>
	 * 
	 * @param register author to DB
	 * @return int 0: success, 1: error
	 *************************************************************/
	public List<Category00VO> execute(Category00VO vo) {

		if (df == null) {
			df = new Dcategory();
		}

		return df.s000(vo);

	}
}
