package com.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadRequestParam extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestParam = req.getParameter("myParam");
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		String message = "<html><body><H1>" + requestParam + "</H1></body></html>";
		writer.println(message);
	}
}
