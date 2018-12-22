package com.book.store.common;
// Đây là Interface

import java.util.List;

import com.book.store.vo.Book00VO;

public interface IIBookStore {
	public List<Book00VO> retrieveBookDetailList(Book00VO vo);
}
