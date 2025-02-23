package com.music_reviews.music_reviews.category;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFound extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CategoryNotFound() {
		super("Category not found");
	}
}
