package com.book.store;

public interface IBaseTM<REQUEST, RESPONSE> {
	public void postProcess(REQUEST request, RESPONSE response);
}
