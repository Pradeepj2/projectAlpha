package com.Alpha.Alpha.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Alpha.Alpha.Dto.BhaktDto;
import com.Alpha.Alpha.Service.BhaktService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class LoginController {
    @Autowired
    private BhaktService bhaktService;
    
	@GetMapping("/registration")
	public String home() {
		return "registration";
	}

	@PostMapping("/registerUser")
	public String registerUser(Model model, @Valid @ModelAttribute("BhaktDto") BhaktDto bhaktDto, BindingResult result,
			RedirectAttributes redirectAttributes, HttpServletRequest request) {
         this.bhaktService.createBhakt(bhaktDto);
         return "success";
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
