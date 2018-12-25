package com.book.store.bf;

import java.util.List;

import com.book.store.df.Dauthor;
import com.book.store.vo.Author00VO;

/**************************************************************
 * <pre>
* Search author by name BF
 * </pre>
 * 
 * @author TRAN VAN MANH
 * @email tranmanh.vn90@gmail.com
 * @importance
 *************************************************************/
public class SearchAuthorByName {

	private Dauthor df = null;

	/**************************************************************
	 * <pre>
	* Execute query author by name
	 * </pre>
	 * 
	 * @param request data object from client
	 * @return Author array
	 *************************************************************/
	public List<Author00VO> execute(Author00VO vo) {
		List<Author00VO> returnList = null;
		if (df == null) {
			df = new Dauthor();
		}
		returnList = df.s000(vo);
		return returnList;
	}
}
