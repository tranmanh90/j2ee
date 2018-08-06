package com.training.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogFilter implements Filter {

	private String logFile;

	public LogFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.logFile = filterConfig.getInitParameter("logFile");
		System.out.println("Log File: " + logFile);
	}

	@Override
	public void destroy() {
		System.out.println("LogFile destroy");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (this.logFile != null) {
			// Ghi thông tin Log vào File.
			this.logToFile(this.logFile);
		}
		chain.doFilter(request, response);
	}

	private void logToFile(String fileName) {
		System.out.println("Write log to file: " + fileName);
	}

}
