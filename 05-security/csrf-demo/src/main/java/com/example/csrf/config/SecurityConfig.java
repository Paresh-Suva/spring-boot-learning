package com.example.csrf.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

// WHAT IS CSRF?
// CSRF MEANS A BAD WEBSITE TRICKS THE USER BROWSER INTO SENDING A REQUEST TO OUR APP.
// THE BROWSER MAY SEND SESSION COOKIES AUTOMATICALLY SO THE SERVER THINKS THE USER WANTED THAT ACTION.

// WHY DOES POST /users FAIL WHEN CSRF IS ENABLED?
// SPRING SECURITY RUNS CsrfFilter BEFORE CONTROLLERS.
// POST IS AN "UNSAFE" METHOD SO THE FILTER EXPECTS A VALID CSRF TOKEN (HEADER + COOKIE OR FORM FIELD).
// A PLAIN JSON POST FROM CURL OR POSTMAN WITH NO TOKEN GETS REJECTED.

// HOW DOES SPRING BLOCK THE REQUEST?
// THE FILTER RETURNS HTTP 403 FORBIDDEN AND STOPS THE CHAIN.
// THE POST HANDLER IN THE REST CONTROLLER IS NEVER CALLED FOR THAT POST.

// WHAT HAPPENS AFTER WE DISABLE CSRF (DEMO ONLY)?
// http.csrf(csrf -> csrf.disable()) REMOVES THAT CHECK.
// POST /users REACHES THE CONTROLLER AND THE NEW USER IS ADDED TO THE LIST.
// REAL APPS SHOULD NOT DISABLE CSRF FOR BROWSER SESSIONS WITHOUT A REPLACEMENT PLAN.

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Value("${app.security.csrf.enabled:true}")
	private boolean csrfEnabled;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// WE USE A SESSION SO A BROWSER CAN GET A CSRF COOKIE WHEN CSRF IS ON (NOT REQUIRED FOR THIS CURL DEMO).
		http.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));

		// NO LOGIN IN THIS DEMO — EVERYONE CAN CALL GET AND POST (CSRF STILL APPLIES TO POST).
		http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());

		// WHEN app.security.csrf.enabled=false WE CALL disable() SO POST /users WORKS WITHOUT A TOKEN.
		if (!csrfEnabled) {
			http.csrf(csrf -> csrf.disable());
		}

		return http.build();
	}
}
