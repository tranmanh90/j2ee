package com.book.store.controller;

import java.io.IOException;
import java.io.RandomAccessFile;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.constant.BTConstants;

@RestController
public class ServingImageRESTController {
	@RequestMapping(value = "/image1", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage1() throws IOException {
		RandomAccessFile f = new RandomAccessFile(BTConstants.COVER_IMAGE_LOCAL_PATH + "", "r");
		byte[] b = new byte[(int) f.length()];
		f.readFully(b);
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		return new ResponseEntity<byte[]>(b, headers, HttpStatus.CREATED);
	}
}
