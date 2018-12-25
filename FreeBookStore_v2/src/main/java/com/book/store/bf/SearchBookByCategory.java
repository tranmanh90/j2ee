package com.book.store.bf;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.book.store.df.Dbook;
import com.book.store.vo.Book03VO;

/**************************************************************
 * <pre>
* Search book by category id
 * </pre>
 * 
 * @author TRAN VAN MANH
 * @email tranmanh.vn90@gmail.com
 * @importance
 *************************************************************/
public class SearchBookByCategory {
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
	public List<Book03VO> execute(Book03VO vo) {
		List<Book03VO> returnList = null;
		returnList = df.s003(vo);
		return returnList;
	}
}
