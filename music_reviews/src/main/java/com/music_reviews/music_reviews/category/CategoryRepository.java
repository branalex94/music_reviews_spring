package com.music_reviews.music_reviews.category;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends ListCrudRepository<Category, Long> {

	public Optional<Category> findByName(String name);
}
