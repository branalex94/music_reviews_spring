package com.music_reviews.music_reviews.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Encrypting {
	private BCryptPasswordEncoder encoder;

	public Encrypting(BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
	}

	public String hashPassword(String password) {
		return encoder.encode(password);
	}

	public boolean validateHash(String password, String hashedPassword) {
		return encoder.matches(password, hashedPassword);
	}
}
