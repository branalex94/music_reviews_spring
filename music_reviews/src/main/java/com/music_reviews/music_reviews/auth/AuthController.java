package com.music_reviews.music_reviews.auth;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.music_reviews.music_reviews.users.User;
import com.music_reviews.music_reviews.users.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private UserService userService;

	public AuthController(UserService userService) {
		this.userService = userService;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("register")
	public void register(@Valid @RequestBody User user) {
		userService.validateUserEmail(user);
		userService.hashUserPassword(user);
		userService.create(user);
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("login")
	public LoginResponseEntity login(
			@RequestBody @Valid LoginRequestEntity login) {
		User user = userService.findByEmail(login.getEmail());
		LoginResponseEntity loggedUser = new LoginResponseEntity(user.Id(),
				user.getEmail());
		return loggedUser;
	}
}
