package com.training.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.spring.utils.MediaTypeUtils;

@Controller
public class InputStreamResourceController {
	private static final String DIRECTORY = "D:/PDF";
	private static final String DEFAULT_FILE_NAME = "java-tutorial.pdf";

	@Autowired
	private ServletContext servletContext;

	// http://localhost:8080/download2?fileName=abc.zip
	// Using ResponseEntity<ByteArrayResource>
	@RequestMapping("/download1")
	public ResponseEntity<InputStreamResource> downloadFile1(
			@RequestParam(defaultValue = DEFAULT_FILE_NAME) String fileName) throws IOException {
		MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, fileName);
		File file = new File(DIRECTORY + "/" + fileName);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		return ResponseEntity.ok()
				// Content-Disposition
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
				// Content-Type
				.contentType(mediaType)
				// Contet-Length
				.contentLength(file.length()).body(resource);
	}
}
