package com.lostphones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lostphones.dto.LoginDto;
import com.lostphones.model.SignUp;
import com.lostphones.repository.SignUpRepository;
import com.lostphones.utils.GenericUtils;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	SignUpRepository signUpRepository;

	@Autowired
	EmailService emailService;

	@Override
	public SignUp checkLogin(LoginDto login) {

		return signUpRepository.findByEmailAndPassword(login.getEmail(), login.getPassword());
	}

	@Override
	public Boolean findByEmail(String forgotPassEmail) {
		return signUpRepository.findByEmail(forgotPassEmail) != null;
	}

	@Override
	public Boolean sendMailForgotPass(String email) {
		int forgotPasswordOtp = GenericUtils.generatePin();
		SignUp signUp = signUpRepository.findByEmail(email);
		if (signUp != null) {
			signUp.setForgotPasswordOtp(forgotPasswordOtp);
			signUp = signUpRepository.save(signUp);
		}
		if (signUp != null) {
			return emailService.sendSimpleMessage(email, "Verify OTP",
					"Your Forgot password otp is :   " + forgotPasswordOtp);
		}
		return false;
	}

	@Override
	public Boolean findByForgotPasswordOtp(int forgotPasswordOtp, String password) {
		SignUp signUp = signUpRepository.findByForgotPasswordOtp(forgotPasswordOtp);
		if (signUp != null) {
			signUp.setForgotPasswordOtp(0);
			String []splitString = password.split(",");
			signUp.setPassword(splitString[0]);
			return signUpRepository.save(signUp) != null;
		}
		return false;
	}

}
