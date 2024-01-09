package com.Alpha.Alpha.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Alpha.Alpha.Dto.BhaktDto;
import com.Alpha.Alpha.Model.ApprovalMessage;
import com.Alpha.Alpha.Model.Bhakt;
import com.Alpha.Alpha.Service.BhaktService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class LoginController {
	@Autowired
	private BhaktService bhaktService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/registration")
	public String registration() {
		return "registration";
	}

	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute Bhakt bhakt, RedirectAttributes redirectAttributes
			,BindingResult result) {
		System.err.println("before");
		System.err.println("before");
		//System.err.println(result.hasErrors());
		System.err.println("after");
		String password = bhakt.getHashPassword();
		bhakt.setHashPassword(passwordEncoder.encode(password));
		if (result.hasErrors()) {
			System.err.println("errrrr");
			System.err.println("errrrr");
			System.err.println("errrrr");
			return "redirect:/registration";
		} else {
			bhaktService.createBhakt(bhakt);
			return "success";
		}
		
		


	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@PostMapping(value = "/approveRegistration")
	public String approveRequest(@RequestParam("id") String id, RedirectAttributes redirectAttributes) {
		String[] parts = id.split("-");

		ApprovalMessage msg = new ApprovalMessage();
		msg.setTo(parts[1]);
		msg.setMessage("Dear " + parts[2] + " , your login request accepted by admin , now you can login easily");

		bhaktService.approve(parts[0]);
		redirectAttributes.addFlashAttribute("sms", msg);
		return "redirect:/sms";
	}

//	@GetMapping("/error")
//	public String error() {
//		System.err.println("this is error in controller");
//		return "error";
//	}

}
