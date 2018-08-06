package com.training.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.beans.Constants;
import com.training.beans.UserInfor;

@WebServlet(urlPatterns = { "/userInfo" })
public class UserInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UserInfoServlet() {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletOutputStream out = resp.getOutputStream();

		// Lấy ra đối tượng HttpSession.
		HttpSession session = req.getSession();

		// Lấy ra đối tượng user đã được lưu trong session, sau kho người dùng login
		// thành công.
		UserInfor loginUser = (UserInfor) session.getAttribute(Constants.SESSION_USER_KEY);

		if (loginUser == null) {
			resp.sendRedirect(this.getServletContext().getContextPath() + "/login");
			return;
		}

		out.println("<html>");
		out.println("<head><title>Session example</title></head>");

		out.println("<body>");

		out.println("<h3>User Info:</h3>");

		out.println("<p>User Name:" + loginUser.getUserName() + "</p>");
		out.println("<p>Country:" + loginUser.getCountry() + "</p>");
		out.println("<p>Post:" + loginUser.getPost() + "</p>");

		out.println("</body>");
		out.println("<html>");
	}

}
