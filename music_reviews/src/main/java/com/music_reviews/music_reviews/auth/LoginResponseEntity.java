package com.music_reviews.music_reviews.auth;

public class LoginResponseEntity {
	private Long id;
	private String email;

	public LoginResponseEntity(Long id, String email) {
		this.setId(id);
		this.setEmail(email);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
