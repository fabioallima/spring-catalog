package com.bootcamp.dscatalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable());
		http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
		
		// fix H2 database console: Refused to display ' in a frame because it set
		// 'X-Frame-Options' to 'deny'
		http.headers(headers -> headers.frameOptions(frameOption -> frameOption.sameOrigin()));

		// http.authenticationProvider(authenticationProvider());

		return http.build();
	}

}
