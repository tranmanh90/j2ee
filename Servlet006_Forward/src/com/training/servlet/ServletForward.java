package com.training.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/other/forwardDemo")
public class ServletForward extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Request:
	// http://localhost:8080/ServletTutorial/other/forwardDemo?forward=true
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Lấy giá trị tham số (parameter) trên URL.
		String forward = req.getParameter("forward");
		if ("true".equals(forward)) {
			System.out.println("Forward to second Servlet");

//			req.setAttribute(Constants.CONSTRUCTOR_NAME, "Hi, I'm Tom come from Walt Disney !");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/second");
			dispatcher.forward(req, resp);

			return;
		}

		ServletOutputStream out = resp.getOutputStream();
		out.println("<h3>Text of ForwardDemoServlet</h3>");
		out.println("- servletPath=" + req.getServletPath());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
