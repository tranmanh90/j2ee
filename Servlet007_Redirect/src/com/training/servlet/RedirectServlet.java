package com.training.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/other/redirect")
public class RedirectServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String redirect = req.getParameter("redirect");
		if ("true".equals(redirect)) {
			System.out.println("Redirect to Second Servlet");
			String contextPath = req.getContextPath();
			resp.sendRedirect(contextPath + "/second");
		}
		ServletOutputStream out = resp.getOutputStream();
		out.println("<h3>Text of RedirectDemoServlet</h3>");
		out.println("- servletPath=" + req.getServletPath());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
