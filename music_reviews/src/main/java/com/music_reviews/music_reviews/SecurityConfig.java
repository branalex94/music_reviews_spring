package com.music_reviews.music_reviews;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.music_reviews.music_reviews.users.UserNotFound;
import com.music_reviews.music_reviews.users.UserRepository;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig {

	private UserRepository userRepository;

	public SecurityConfig(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Bean
	public BCryptPasswordEncoder bCryptEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public UserDetailsService users() {
//		// The builder will ensure the passwords are encoded before saving in
//		// memory
//		UserDetails user = User.withUsername("user")
//				.password(bCryptEncoder().encode("password")).build();
//		return new InMemoryUserDetailsManager(user);
//	}

	@Bean
	UserDetailsService userDetailsService() {
		return username -> userRepository.findByEmail(username)
				.orElseThrow(() -> new UserNotFound());
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)
			throws Exception {
		http.authorizeHttpRequests((requests) -> requests
				// .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				// .requestMatchers("/**").permitAll()
				.requestMatchers("/api/auth/**").permitAll()
				.requestMatchers("/error").permitAll()
				.requestMatchers("/api/**").authenticated()

		// .anyRequest().authenticated()
		// se
		// elimino
		// hasta
		// entender
		// como
		// funciona
		// el
		// auth
		).httpBasic(Customizer.withDefaults())
				.csrf((csrf) -> csrf.ignoringRequestMatchers("/**"));
		return http.build();
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/api/auth/**").allowedMethods("*")
//						.allowedOrigins("http://localhost:4200");
//				registry.addMapping("/api/**").allowedMethods("*")
//						.allowedOrigins("http://localhost:4200");
//			}
//		};
//	}
}
