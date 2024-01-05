package com.Alpha.Alpha.Service;
import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Service
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
	 
		var authorities = authentication.getAuthorities();
 
		var roles = authorities.stream().map(r -> r.getAuthority()).findFirst();
		System.err.println(roles);
		System.err.println(roles);
		System.err.println(roles);
		if (roles.orElse("").equals("ROLE_Admin")) {
			response.sendRedirect("/admin");
		} else if (roles.orElse("").equals("ROLE_User")) {
			response.sendRedirect("/user");
		} else {
			response.sendRedirect("/error");
		}
	}

}
