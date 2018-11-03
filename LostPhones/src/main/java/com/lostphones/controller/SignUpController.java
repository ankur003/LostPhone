package com.lostphones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lostphones.dto.ForgotPasswordDto;
import com.lostphones.dto.LoginDto;
import com.lostphones.dto.OtpDto;
import com.lostphones.model.SignUp;
import com.lostphones.service.SignUpService;

import io.swagger.annotations.Api;

@RestController
@Api
public class SignUpController {

	@Autowired
	SignUpService signUpService;

	private static final String USER_SAVED = "userSaved";

	private static final String EMAIL_VERIFY = "passwordReset";

	@PostMapping(value = "/SignUp")
	public ModelAndView signUp(@ModelAttribute("signup") SignUp signUp, Model model) {

		boolean isSaved = signUpService.saveSignUpDetails(signUp);

		if (isSaved) {
			model.addAttribute("otp", new OtpDto());
			model.addAttribute("userEmailToverify", signUp.getEmail());
			model.addAttribute(USER_SAVED,
					"Congo !!! You Just One Step Away to Access Globle Database ! Please Enter Otp");
			return new ModelAndView(EMAIL_VERIFY);
		}
		model.addAttribute(USER_SAVED, "please try again");
		return new ModelAndView("signUp");
	}

	@PostMapping(value = "/verifyEmailOtp")
	public ModelAndView verifyOtp(@ModelAttribute("otp") OtpDto otp, Model model) {
		model.addAttribute("otp", new OtpDto());
		String verifyEmail = otp.getEmail();
		int validateOtp = otp.getOtp();
		if (validateOtp <= 0) {
			model.addAttribute(USER_SAVED, " Please Enter correct Otp");
			return new ModelAndView(EMAIL_VERIFY);
		}
		boolean isSaved = signUpService.verifyUserEmail(validateOtp, verifyEmail);
		if (isSaved) {
			model.addAttribute("login", new LoginDto());
			model.addAttribute("forgotPassword", new ForgotPasswordDto());
			model.addAttribute(USER_SAVED, "Congo !!! You Just One Step Away to Access Globle Database ! Please Login");
			return new ModelAndView("login");
		}
		model.addAttribute(USER_SAVED, " Please Enter correct Otp");
		return new ModelAndView(EMAIL_VERIFY);
	}
}
