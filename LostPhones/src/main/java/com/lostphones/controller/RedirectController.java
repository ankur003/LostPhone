package com.lostphones.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lostphones.dto.ForgotPasswordDto;
import com.lostphones.dto.LoginDto;
import com.lostphones.dto.OtpDto;
import com.lostphones.model.SignUp;

@Controller
public class RedirectController {

	// when application runs using localhost:port logout
	@GetMapping(value = "/")
	public ModelAndView index(Model model) {
		return new ModelAndView("index");
	}

	// when click on signUp button to open signup form
	@GetMapping(value = "/signUp")
	public String signUp(Model model) {
		model.addAttribute("signup", new SignUp());
		return "signUp";
	}

	// when click on login button to open login form
	@GetMapping(value = "/login")
	public String login(Model model) {
		model.addAttribute("login", new LoginDto());
		model.addAttribute("forgotPassword", new ForgotPasswordDto());
		return "login";
	}

	@GetMapping(value = "logout")
	public ModelAndView logout(Model model) {
		return new ModelAndView("logout");
	}

	@GetMapping(value = "passwordReset")
	public ModelAndView passwordReset(Model model) {
		model.addAttribute("otp", new OtpDto());
		return new ModelAndView("passwordReset");
	}

	@GetMapping(value = "userHome")
	public ModelAndView userHome(Model model) {

		return new ModelAndView("userHome");
	}
}
