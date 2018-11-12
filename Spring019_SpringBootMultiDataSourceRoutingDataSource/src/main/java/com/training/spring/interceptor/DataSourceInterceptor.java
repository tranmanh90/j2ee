package com.training.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DataSourceInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String contextPath = request.getServletContext().getContextPath();
		String prefixPublisher = contextPath + "/publisher";
		String prefixAdvertiser = contextPath + "/advertiser";
		String uri = request.getRequestURI();
		if (uri.startsWith(prefixPublisher)) {
			request.setAttribute("keyDS", "PUBLISHER_DS");
		} else if (uri.startsWith(prefixAdvertiser)) {
			request.setAttribute("keyDS", "ADVERTISER_DS");
		}
		return true;
	}

}
