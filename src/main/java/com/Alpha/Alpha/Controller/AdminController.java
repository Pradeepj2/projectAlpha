package com.Alpha.Alpha.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Alpha.Alpha.Model.Bhakt;
import com.Alpha.Alpha.Service.BhaktService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	BhaktService bhaktService;

	@GetMapping("")
	public String admin() {
		return "admin";
	}

	@GetMapping("/pendingRequest")
	public String admin1(Model model) {
		
		
		List<Bhakt> list = bhaktService.getAllPendingRequest();
		
		for(Bhakt eleBhakt : list) {
			System.err.println(eleBhakt.toString());
		}
		
		model.addAttribute("list" , list);
		
		
		return "pendingRequest";
	}

	@GetMapping("/admin2")
	public String admin2() {
		return "admin2";
	}
}
