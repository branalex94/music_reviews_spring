package com.music_reviews.music_reviews.users;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.music_reviews.music_reviews.exceptions.BadRequestException;
import com.music_reviews.music_reviews.exceptions.NotFoundException;
import com.music_reviews.music_reviews.utils.Encrypting;
import com.music_reviews.music_reviews.utils.Validations;

@Service
public class UserService {

	private static final org.slf4j.Logger logger = LoggerFactory
			.getLogger(UserService.class);
	private UserRepository userRepository;
	private Validations validations;
	private Encrypting encrypting;

	public UserService(UserRepository userRepository, Validations validations,
			Encrypting encrypting) {
		this.userRepository = userRepository;
		this.validations = validations;
		this.encrypting = encrypting;
	}

	public void hashUserPassword(User user) {

		String encryptedPassword = encrypting.hashPassword(user.getPassword());
		user.setPassword(encryptedPassword);
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());
	}

	public void validateUserEmail(User user) {
		boolean isValidEmail = validations.validateEmail(user.getEmail());

		if (!isValidEmail) {
			throw new BadRequestException("Email must be of a valid format");
		}
	}

	public User create(User user) {
		return this.userRepository.save(user);
	}

	public User findById(Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new NotFoundException("User not found");
		}
		return user.get();
	}

	public User findByEmail(String email) {
		Optional<User> user = userRepository.findByEmail(email);
		if (user.isEmpty()) {
			throw new NotFoundException("User not found");
		}
		return user.get();
	}
}
