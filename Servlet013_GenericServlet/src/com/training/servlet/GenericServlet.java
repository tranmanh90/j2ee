package com.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GenericServlet extends javax.servlet.GenericServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		String hello = "<html><body><H1>Hello World Servlet With extends Generic Servlet</H1></body></html>";
		writer.println(hello);
	}

}
