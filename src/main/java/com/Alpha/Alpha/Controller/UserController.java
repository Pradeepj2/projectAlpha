package com.Alpha.Alpha.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("")
	public String user() {
		return "user";
		
	}
	@GetMapping("/user2")
	public String user2() {
		return "user2";
		
	}
	@GetMapping("/user3")
	public String user3() {
		return "user3";
		
	}
}
