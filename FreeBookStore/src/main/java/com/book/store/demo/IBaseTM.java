package com.book.store.demo;

public interface IBaseTM<REQUEST, RESPONSE> {
	public void postProcess(REQUEST request, RESPONSE response);
}
