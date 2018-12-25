package com.book.store.bf;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.book.store.df.Dbook;
import com.book.store.vo.Book02VO;

/**************************************************************
 * <pre>
* Search book by author id
 * </pre>
 * 
 * @author TRAN VAN MANH
 * @email tranmanh.vn90@gmail.com
 * @importance
 *************************************************************/
public class SearchBookByAuthor {
	private String className = getClass().getName();
	private Logger logger = LoggerFactory.getLogger(className);

	private Dbook df = new Dbook();

	/**************************************************************
	 * <pre>
	* Execute search action
	 * </pre>
	 * 
	 * @param vo request data from client
	 * @return A searched books
	 *************************************************************/
	public List<Book02VO> execute(Book02VO vo) {
		List<Book02VO> returnList = null;
		returnList = df.s002(vo);
		return returnList;
	}
}
