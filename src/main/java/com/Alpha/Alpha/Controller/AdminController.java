package com.Alpha.Alpha.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("")
	public String admin() {
		return "admin";
	}
	@GetMapping("/admin1")
	public String admin1() {
		return "admin1";
	}
	@GetMapping("/admin2")
	public String admin2() {
		return "admin2";
	}
}
