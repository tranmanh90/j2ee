package com.book.store.bf;

import java.util.List;

import com.book.store.df.Dauthor;
import com.book.store.vo.Author00VO;

/**************************************************************
 * <pre>
* Search author by id BF
 * </pre>
 * 
 * @author TRAN VAN MANH
 * @email tranmanh.vn90@gmail.com
 * @importance
 *************************************************************/
public class SearchAuthorById {
	private Dauthor df = null;

	/**************************************************************
	 * <pre>
	* Execute query author by id
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
		returnList = df.s001(vo);
		return returnList;
	}
}
