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
 
		var roles = authorities.stream().map(r -> r.getAuthority()).findFirst().orElse("");
		System.err.println(roles.equals("Admin"));
		System.err.println(roles);
		System.err.println(roles);
		if (roles.equals("Admin")== true) {
			response.sendRedirect("/admin");
		} else if (roles.equals("User")) {
			response.sendRedirect("/user");
		} else {
			System.err.println("this is error in custom user details service");
			response.sendRedirect("/error");
		}
	}

}
