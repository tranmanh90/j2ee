package com.book.store.bf;

import java.util.List;

import com.book.store.df.Dauthor;
import com.book.store.vo.Author00VO;

public class RegisterAuthor {
	
	private Dauthor df = null;

	/**************************************************************
	 * <pre>
	* Execute query author by id
	 * </pre>
	 * 
	 * @param register author to DB
	 * @return int 0: success, 1: error
	 *************************************************************/
	public int execute(Author00VO vo) {
		
		if (df == null) {
			df = new Dauthor();
		}
		
//		try {
			df.i000(vo);
			return 0;
//		}catch (Exception e) {
//			System.out.println("ERROR SQL INSERT " + e);
//			return 1;
//		}
	}
}
