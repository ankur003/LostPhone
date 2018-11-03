package com.lostphones.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lostphones.dto.ForgotPasswordDto;
import com.lostphones.dto.ForgotPasswordOtpDto;
import com.lostphones.dto.LoginDto;
import com.lostphones.model.SignUp;
import com.lostphones.service.LoginService;

import io.swagger.annotations.Api;

@Controller
@Api
public class LoginController {

	@Autowired
	LoginService loginService;

	private static final String USER_SAVED = "userSaved";

	private static final String LOGIN = "login";

	private static final String FORGOT_PASS = "forgotPassword";

	/**
	 * @description use to login of user
	 * @param login
	 * @param model
	 * @param request
	 * @return
	 */
	@PostMapping(value = "/Login")
	public ModelAndView signUp(@ModelAttribute("login") LoginDto login, Model model, HttpServletRequest request) {
		SignUp isSuccess = loginService.checkLogin(login);
		if (isSuccess != null) {
			if (isSuccess.isUserVarified()) {
				model.addAttribute("userfullname", isSuccess.getFullName());
				HttpSession session = request.getSession();
				session.setAttribute("userfullname", isSuccess.getFullName());
				return new ModelAndView("userHome");
			}
			model.addAttribute(USER_SAVED, "OH !!!  please varify your email");
			model.addAttribute(FORGOT_PASS, new ForgotPasswordDto());
			return new ModelAndView(LOGIN);
		}
		model.addAttribute(USER_SAVED, "OH !!!  Invalid Credentials");
		model.addAttribute(FORGOT_PASS, new ForgotPasswordDto());
		return new ModelAndView(LOGIN);
	}

	/**
	 * @description use to send email on user email
	 * @param forgotPass
	 * @param model
	 * @param request
	 * @return
	 */

	@PostMapping(value = "/ForgotPassword")
	public ModelAndView signUp(@ModelAttribute("forgotPassword") ForgotPasswordDto forgotPass, Model model,
			HttpServletRequest request) {
		Boolean isFound = loginService.findByEmail(forgotPass.getEmail());
		if (isFound) {
			boolean isSend = loginService.sendMailForgotPass(forgotPass.getEmail());
			if (isSend) {
				model.addAttribute(USER_SAVED, "OTP Sent to your email , please verify");
				model.addAttribute("forgotPassOtp", new ForgotPasswordOtpDto());
				return new ModelAndView(FORGOT_PASS);
			}
			model.addAttribute(USER_SAVED, "Something went wrong while sending email , please try agian");
			model.addAttribute(LOGIN, new LoginDto());
			return new ModelAndView(LOGIN);
		}
		model.addAttribute(USER_SAVED, "OH !!! Not a valid Email , Please try again !!!");
		model.addAttribute(LOGIN, new LoginDto());
		return new ModelAndView(LOGIN);
	}

	/**
	 * @description use to check otp which was send on email 
	 * @param forgotPass
	 * @param model
	 * @param request
	 * @return
	 */
	@PostMapping(value = "/VerifyOtpForForgotPass")
	public ModelAndView forgotPasswordOtp(@ModelAttribute("forgotPassOtp") ForgotPasswordOtpDto forgotPass, Model model,
			HttpServletRequest request) {

		Boolean isFound = loginService.findByForgotPasswordOtp(forgotPass.getOtp(), forgotPass.getPassword());
		if (isFound) {
			model.addAttribute(USER_SAVED, "Great !!! You can Login Now !!! ");
			model.addAttribute(LOGIN, new LoginDto());
			model.addAttribute(FORGOT_PASS, new ForgotPasswordDto());
			return new ModelAndView(LOGIN);
		}
		model.addAttribute(USER_SAVED, "Oh !!! Invalid OTP");
		model.addAttribute("forgotPassOtp", new ForgotPasswordOtpDto());
		return new ModelAndView(FORGOT_PASS);
	}
}
