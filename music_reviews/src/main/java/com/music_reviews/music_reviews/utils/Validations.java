package com.music_reviews.music_reviews.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class Validations {

	private String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

	public boolean validateEmail(String email) {
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);

		return matcher.find();
	}
}
