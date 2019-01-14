package com.book.store.bf;

import java.util.List;

import com.book.store.df.Dauthor;
import com.book.store.vo.Author00VO;
import com.book.store.vo.Book00VO;

/**************************************************************
 * <pre>
* Search author list by book ID BF
 * </pre>
 * 
 * @author TRAN VAN MANH
 * @email tranmanh.vn90@gmail.com
 * @importance
 *************************************************************/
public class SearchAuthorListByBookId {

	private Dauthor df = null;

	/**************************************************************
	 * <pre>
	* Execute query author list by book ID
	 * </pre>
	 * 
	 * @param request data object from client
	 * @return Author array
	 *************************************************************/
	public List<Author00VO> execute(Book00VO vo) {
		List<Author00VO> returnList = null;
		if (df == null) {
			df = new Dauthor();
		}
		returnList = df.s002(vo);
		return returnList;
	}

}
