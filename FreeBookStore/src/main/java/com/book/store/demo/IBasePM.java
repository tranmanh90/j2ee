package com.book.store.demo;

public interface IBasePM<REQUEST extends BaseRequest, RESPONSE extends BaseRespone> {
	public RESPONSE execute(REQUEST request);
}
