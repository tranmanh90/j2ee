package com.training.spring.config;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.LocaleResolver;

public class UrlLocaleResolver implements LocaleResolver {

	private static final String URL_LOCALE_ATTRIBUTE_NAME = "URL_LOCALE_ATTRIBUTE_NAME";

	// ==> /SomeContextPath/en/...
	// ==> /SomeContextPath/fr/...
	// ==> /SomeContextPath/WEB-INF/pages/...
	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String uri = request.getRequestURI();
		System.out.println("URI = " + uri);

		String prefixEn = request.getServletContext().getContextPath() + "/en/";
		String prefixFr = request.getServletContext().getContextPath() + "/fr/";
		String prefixVi = request.getServletContext().getContextPath() + "/vi/";

		Locale locale = null;

		// English
		if (uri.startsWith(prefixEn)) {
			locale = Locale.ENGLISH;
		} else if (uri.startsWith(prefixFr)) {
			locale = Locale.FRANCE;
		} else if (uri.startsWith(prefixVi)) {
			locale = new Locale("vi", "VN");
		}

		if (locale != null) {
			request.getSession().setAttribute(URL_LOCALE_ATTRIBUTE_NAME, locale);
		}
		if (locale == null) {
			locale = (Locale) request.getSession().getAttribute(URL_LOCALE_ATTRIBUTE_NAME);
			if (locale == null) {
				locale = Locale.ENGLISH;
			}
		}
		return locale;
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		// TODO Auto-generated method stub

	}

}
