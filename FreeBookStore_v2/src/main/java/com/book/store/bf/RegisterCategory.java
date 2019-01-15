package com.book.store.bf;

import com.book.store.df.Dauthor;
import com.book.store.df.Dcategory;
import com.book.store.vo.Author00VO;
import com.book.store.vo.Category00VO;

public class RegisterCategory {
	
	private Dcategory df = null;

	/**************************************************************
	 * <pre>
	 * Execute query author by id
	 * </pre>
	 * 
	 * @param register author to DB
	 * @return int 0: success, 1: error
	 *************************************************************/
	public int execute(Category00VO vo) {

		if (df == null) {
			df = new Dcategory();
		}
		return df.i000(vo);
	}
}
