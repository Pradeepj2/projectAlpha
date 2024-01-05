package com.Alpha.Alpha.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginCintroller {

	@GetMapping("/registration")
	public String home() {
		return "registration";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/error")
	public String error() {
		return "error";
	}

}
