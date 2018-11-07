package com.training.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class ThymeleafViewResolverConfig {

	// Thymeleaf template resolver serving HTML 5
	@Bean
	public ITemplateResolver thymeleafTemplateResolver() {
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setPrefix("templates/");
		templateResolver.setCacheable(false);
		templateResolver.setSuffix(".html");
		templateResolver.setCharacterEncoding("UTF-8");
		return templateResolver;
	}

	// Thymeleaf template engine with Spring integration
	@Bean
	public SpringTemplateEngine thymeleafTemplateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(thymeleafTemplateResolver());
		templateEngine.setEnableSpringELCompiler(true);
		return templateEngine;
	}

	@Bean
	public SpringResourceTemplateResolver springResourceTemplateResolver() {
		return new SpringResourceTemplateResolver();
	}

	@Bean
	public ViewResolver thymeleafViewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(thymeleafTemplateEngine());
		viewResolver.setCharacterEncoding("UTF-8");
		viewResolver.setOrder(0);

		// Important!!
		// th_page1.html, th_page2.html, ...
		viewResolver.setViewNames(new String[] { "th_*" });
		return viewResolver;
	}
}
