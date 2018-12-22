package com.book.store;

public interface IBasePM<REQUEST extends BaseRequest, RESPONSE extends BaseRespone> {
	public RESPONSE execute(REQUEST request);
}
