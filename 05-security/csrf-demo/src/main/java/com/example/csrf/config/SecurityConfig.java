package com.example.csrf.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Value("${app.security.csrf.enabled:true}")
	private boolean csrfEnabled;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));
		http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());

		// WHEN app.security.csrf.enabled=false WE CALL disable() SO POST /users WORKS WITHOUT A TOKEN.
		if (!csrfEnabled) {
			http.csrf(csrf -> csrf.disable());
		}

		return http.build();
	}
}
