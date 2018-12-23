package com.book.store.bf;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.book.store.df.Dbook;
import com.book.store.vo.Book00VO;

/**************************************************************
 * <pre>
* Search by book Id
 * </pre>
 * 
 * @author TRAN VAN MANH
 * @email tranmanh.vn90@gmail.com
 * @importance
 *************************************************************/
public class SearchBookById {
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
	public List<Book00VO> execute(Book00VO vo) {
		List<Book00VO> returnList = null;
		returnList = df.s001(vo);
		return returnList;
	}
}
