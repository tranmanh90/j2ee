package com.book.store.bf;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.book.store.df.Dbook;
import com.book.store.vo.Book04VO;

/**************************************************************
 * <pre>
* Search book by containing words
 * </pre>
 * 
 * @author TRAN VAN MANH
 * @email tranmanh.vn90@gmail.com
 * @importance
 *************************************************************/
public class SearchBookByContainingWords {
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
	public List<Book04VO> execute(Book04VO vo) {
		List<Book04VO> returnList = null;
		returnList = df.s004(vo);
		return returnList;
	}
}
