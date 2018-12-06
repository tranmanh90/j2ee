package com.book.store.controller;

import java.io.IOException;
import java.io.RandomAccessFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.dao.CoverImageDAO;
import com.book.store.model.CoverImage;

@RestController
public class ServingImageRESTController {
	
	@Autowired
	private CoverImageDAO coverImageDAO;
	
	@RequestMapping(value = "/image/{urlId}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getCoverImageByUrlId(@PathVariable("urlId") String urlId) throws IOException {
		CoverImage coverImage = coverImageDAO.getCoverImageByUrlId(urlId);
		final HttpHeaders headers = new HttpHeaders();
		if(coverImage != null) {
			/* "D:/Document/Media/cover" + "/" + "CV0000000000" + "." + "png" */
			RandomAccessFile f = new RandomAccessFile(coverImage.getImagePath() + "/" + coverImage.getImageName() + "." + coverImage.getImageFormat(), "r");
			byte[] b = new byte[(int) f.length()];
			f.readFully(b);
			headers.setContentType(MediaType.IMAGE_JPEG);
			return new ResponseEntity<byte[]>(b, headers, HttpStatus.CREATED);
		}
		return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
	}
	
}
