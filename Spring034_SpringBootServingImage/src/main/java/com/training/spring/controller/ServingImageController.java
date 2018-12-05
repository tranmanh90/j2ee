package com.training.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServingImageController {
	
	public static final String ROOT_PATH = "D:/Document/";
	public static final String SUB_PATH = "Media/";


	@RequestMapping(value = "/image/{imagePath}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage1(@PathVariable("imagePath") String imagePath) throws IOException {
		RandomAccessFile f = new RandomAccessFile("D:/Document/Media/wpp.jpg", "r");
		byte[] b = new byte[(int) f.length()];
		f.readFully(b);
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		return new ResponseEntity<byte[]>(b, headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/image2", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public void getImage2(HttpServletResponse response) throws IOException {
//		ClassPathResource imgFile = new ClassPathResource("images/wpp.jpg");
		File file = new File("D:/Document/Media/wpp.jpg");
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//		StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
		StreamUtils.copy(new FileInputStream(file), response.getOutputStream());
		System.out.println("================> " + file.toURI());
	}

	@RequestMapping(value = "/image3", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<InputStreamResource> getImage3() throws IOException {
//		ClassPathResource imgFile = new ClassPathResource("images/wpp.jpg");
		File file = new File("D:/Document/Media/wpp.jpg");
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
				.body(new InputStreamResource(new FileInputStream(file)));
	}

	@RequestMapping(value = "/image4", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getImage4() throws IOException {
//		ClassPathResource imgFile = new ClassPathResource("image/sid.jpg");
		File file = new File("D:/Document/Media/wpp.jpg");
		byte[] bytes = StreamUtils.copyToByteArray(new FileInputStream(file));
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
	}
}
