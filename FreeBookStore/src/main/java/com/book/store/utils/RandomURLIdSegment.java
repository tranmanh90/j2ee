package com.book.store.utils;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Base64.Encoder;

public class RandomURLIdSegment {
	public String generateUrlIdSegment() {
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[16];
		random.nextBytes(bytes);
		Encoder encoder = Base64.getUrlEncoder().withoutPadding();
		return encoder.encodeToString(bytes);
	}
}
