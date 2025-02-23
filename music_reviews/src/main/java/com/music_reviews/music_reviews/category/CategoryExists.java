package com.music_reviews.music_reviews.category;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CategoryExists extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CategoryExists() {
		super("Category already exists");
	}
}
