package com.music_reviews.music_reviews.category;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.music_reviews.music_reviews.products.ProductNotFound;

@Service
public class CategoryService {
	private final Logger logger = LoggerFactory
			.getLogger(CategoryService.class);
	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public void create(Category category) {
		logger.info("category: " + category);
		Optional<Category> existingCategory = categoryRepository
				.findByName(category.getName());
		if (existingCategory.isPresent()) {
			throw new CategoryExists();
		}
		LocalDateTime timestamp = LocalDateTime.now();

		category.setCreatedAt(timestamp);
		category.setUpdatedAt(timestamp);
		this.categoryRepository.save(category);
	}

	public Category findById(Long id) {
		Optional<Category> existingCategory = categoryRepository.findById(id);
		if (existingCategory.isEmpty()) {
			throw new ProductNotFound();
		}
		return existingCategory.get();
	}
}
