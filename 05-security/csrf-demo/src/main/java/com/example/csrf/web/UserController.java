package com.example.csrf.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.csrf.model.User;

// THIS CLASS IS THE REST CONTROLLER.
// IT HOLDS THE IN-MEMORY LIST (NO DATABASE).
@RestController
public class UserController {

	private final List<User> users = Collections.synchronizedList(new ArrayList<>());

	private final AtomicLong nextId = new AtomicLong(3);

	public UserController() {
		users.add(new User(1L, "Rahul"));
		users.add(new User(2L, "Amit"));
	}

	// @GetMapping MEANS BROWSER OR POSTMAN CAN CALL GET /users.
	// CSRF DOES NOT BLOCK GET — ONLY "UNSAFE" METHODS LIKE POST ARE CHECKED.
	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> listUsers() {
		return new ArrayList<>(users);
	}

	// @PostMapping MEANS CLIENT SENDS POST /users WITH JSON BODY.
	// WHEN CSRF IS ON, SPRING SECURITY BLOCKS THIS BEFORE WE ENTER THIS METHOD UNLESS TOKEN IS SENT.
	@PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody User body) {

		Long id = (body != null && body.getId() != null) ? body.getId() : nextId.getAndIncrement();

		String name = (body != null && body.getName() != null && !body.getName().isBlank())
				? body.getName()
				: "Unknown";
		User saved = new User(id, name);
		users.add(saved);
		nextId.updateAndGet(current -> Math.max(current, id + 1));
		return saved;
	}
}
