package com.music_reviews.music_reviews.users;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.music_reviews.music_reviews.exceptions.NotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserRepository userRepository;
	private UserService userService;

	private static final org.slf4j.Logger logger = LoggerFactory
			.getLogger(UserController.class);

	public UserController(UserRepository userRepository,
			UserService userService) {
		this.userRepository = userRepository;
		this.userService = userService;
	}

	@GetMapping("")
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public User findById(@PathVariable Integer id) {
		return userService.findById(id);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PatchMapping("/{id}")
	public void update(@Valid @RequestBody User user,
			@PathVariable Integer id) {
		Optional<User> findUser = userRepository.findById(id);

		if (!findUser.isPresent()) {
			throw new NotFoundException("User not found");
		}
		userRepository.save(user);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		User findUser = findById(id);
		userRepository.delete(findUser);
	}
}
