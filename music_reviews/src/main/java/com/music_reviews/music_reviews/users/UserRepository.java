package com.music_reviews.music_reviews.users;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, Integer> {

	public Optional<User> findByEmail(String email);
}
