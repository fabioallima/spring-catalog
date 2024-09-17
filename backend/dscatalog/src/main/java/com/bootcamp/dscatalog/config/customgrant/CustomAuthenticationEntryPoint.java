package com.bootcamp.dscatalog.config.customgrant;

import java.io.IOException;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		response.setContentType("application/json");

		if (authException instanceof InsufficientAuthenticationException) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Credenciais inválidas ou não fornecidas");
		} else if (authException instanceof BadCredentialsException) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Credenciais inválidas");
		} else {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Erro de autenticação");
		}	
	}
}
