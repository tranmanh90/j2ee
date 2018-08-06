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

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		// default
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletOutputStream out = resp.getOutputStream();

		// Lấy ra đối tượng session
		HttpSession session = req.getSession();

		// Giả sử người dùng login thành công
		UserInfor userInfor = new UserInfor("TRAN VAN MANH", 100000, "VIETNAM");

		// Lưu thông tin người dùng vào một thuộc tính của Session.
		session.setAttribute(Constants.SESSION_USER_KEY, userInfor);

		out.println("<html>");
		out.println("<head><title>Session example</title></head>");

		out.println("<body>");
		out.println("<h3>You are logined!, info stored in session</h3>");

		out.println("<a href='userInfo'>View User Info</a>");
		out.println("</body>");
		out.println("<html>");
	}
}
