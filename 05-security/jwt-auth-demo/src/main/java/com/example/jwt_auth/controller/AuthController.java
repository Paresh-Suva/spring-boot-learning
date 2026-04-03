package com.example.jwt_auth.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt_auth.dto.LoginRequest;
import com.example.jwt_auth.dto.LoginResponse;
import com.example.jwt_auth.dto.MessageResponse;
import com.example.jwt_auth.dto.ProfileResponse;
import com.example.jwt_auth.dto.RegisterRequest;
import com.example.jwt_auth.entity.User;
import com.example.jwt_auth.security.JwtUtil;
import com.example.jwt_auth.service.UserService;

@RestController
public class AuthController {

	private final UserService userService;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;

	public AuthController(UserService userService, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
	}


	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MessageResponse> register(@RequestBody RegisterRequest request) {

		if (userService.findByUsername(request.getUsername()).isPresent()) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new MessageResponse("Username already taken"));
		}

		userService.registerUser(request.getUsername(), request.getPassword());

		return ResponseEntity.status(HttpStatus.CREATED).body(new MessageResponse("User registered successfully"));
	}

	// CHECKS PASSWORD THEN RETURNS JWT token STRING
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> login(@RequestBody LoginRequest request) {

		Optional<User> opt = userService.findByUsername(request.getUsername());

		// THIS LINE RETURNS 401 IF USER DOES NOT EXIST.
		if (opt.isEmpty()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse("Invalid username or password"));
		}
		User user = opt.get();

		if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {

			// THIS LINE RETURNS 401 IF PASSWORD WRONG.
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse("Invalid username or password"));
		}

		String token = jwtUtil.generateToken(user.getUsername());

		return ResponseEntity.ok(new LoginResponse(token));
	}


	@GetMapping(value = "/profile", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProfileResponse profile(Authentication authentication) {

		String username = authentication.getName();

		return new ProfileResponse(username, "This is protected data");
	}
}
