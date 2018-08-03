package com.training.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/other/exampleInfor"})
public class GetServletInfor extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public GetServletInfor() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletOutputStream outputStream = resp.getOutputStream();
		outputStream.println("<style> span {color:blue;} </style>");
		
		String requestURL = req.getRequestURL().toString();
		outputStream.println("<br><span>requestURL:</span>");
		outputStream.println(requestURL);
		
		String requestURI = req.getRequestURI();
		outputStream.println("<br><span>requestURI:</span>");
		outputStream.println(requestURI);
		
		String contextPath = req.getContextPath();
		outputStream.println("<br><span>contextPath:</span>");
		outputStream.println(contextPath);
		
		String servletPath = req.getServletPath();
		outputStream.println("<br><span>servletPath:</span>");
		outputStream.println(servletPath);
		
		String queryString = req.getQueryString();
		outputStream.println("<br><span>queryString:</span>");
		outputStream.println(queryString);
		
		String param1 = req.getParameter("text1");
		outputStream.println("<br><span>getParameter text1:</span>");
		outputStream.println(param1);
		
		String param2 = req.getParameter("text2");
		outputStream.println("<br><span>getParameter text2:</span>");
		outputStream.println(param2);
		
		// Server Infos
		outputStream.println("<br><br><b>Server info:</b>");
		String serverName = req.getServerName();
		outputStream.println("<br><span>serverName:</span>");
		outputStream.println(serverName);
		
		int serverPort = req.getServerPort();
		outputStream.println("<br><span>serverPort:</span>");
		outputStream.println(serverPort + "");
		
		// Client Infos
		outputStream.println("<br><br><b>Client info:</b>");
		String remoteAddr = req.getRemoteAddr();
		outputStream.println("<br><span>remoteAddr:</span>");
		outputStream.println(remoteAddr);
		
		String remoteHost = req.getRemoteHost();
		outputStream.println("<br><span>remoteHost:</span>");
		outputStream.println(remoteHost);
		
		int remotePort = req.getRemotePort();
		outputStream.println("<br><span>remotePort:</span>");
		outputStream.println(remotePort);
		
		String remoteUser = req.getRemoteUser();
		outputStream.println("<br><span>remoteUser:</span>");
		outputStream.println(remoteUser);
		
		// Header Infos
		outputStream.println("<br><br><b>headers:</b>");
		Enumeration<String> headers = req.getHeaderNames();
		while(headers.hasMoreElements()) {
			String header = headers.nextElement();
			outputStream.println("<br><span>" + header + "</span>: " + req.getHeader(header));
		}
		
		// Servlet Context info:
		outputStream.println("<br><br><b>Servlet Context info:</b>");
		ServletContext context = req.getServletContext();
		outputStream.println(context.toString());
		
		//Vị trí của ứng dụng web trên ổ cứng (hard disk).
		outputStream.println("<br><span>realPath:</span>");
		String realPath = context.getRealPath("");
		outputStream.println(realPath);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
		this.doGet(req, resp);
	}
	
	
}
