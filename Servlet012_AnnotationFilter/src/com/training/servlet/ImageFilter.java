package com.training.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "*.png", "*.jpg" }, initParams = {
		@WebInitParam(name = "imageNotFound", value = "/images/not-found.png") })
public class ImageFilter implements Filter {

	private String imageNotFound;

	public ImageFilter() {
		super();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

		// ==> /images/path/my-image.png
		// ==> /path1/path2/image.pngs
		String serverPath = req.getServletPath();

		// Đường dẫn tuyệt đối của thư mục gốc của WebApp (WebContent).
		String rootPath = request.getServletContext().getRealPath("");

		// Đường dẫn tuyệt đối tới file ảnh.
		String imagePath = rootPath + serverPath;

		System.out.println("Image path: " + imagePath);

		File file = new File(imagePath);
		
		System.out.println("File có tồn tại không: " + file.exists());

		// Kiểm tra xem ảnh có tồn tại không.
		if (file.exists()) {
			// Cho phép request được đi tiếp. (Vượt qua Filter này).
			// (Để đi tiếp tới file ảnh yêu cầu).
			chain.doFilter(request, response);
		} else if (!serverPath.equals(this.imageNotFound)) {
			// Redirect (Chuyển hướng) tới file ảnh 'image not found'.
			HttpServletResponse resp = (HttpServletResponse) response;
			System.out.println("============> " + req.getContextPath() + this.imageNotFound);
			resp.sendRedirect(req.getContextPath() + this.imageNotFound);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		imageNotFound = filterConfig.getInitParameter("imageNotFound");
	}

}
