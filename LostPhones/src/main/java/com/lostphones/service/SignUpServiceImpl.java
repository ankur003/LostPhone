package com.lostphones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lostphones.model.SignUp;
import com.lostphones.repository.SignUpRepository;
import com.lostphones.utils.GenericUtils;

@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	SignUpRepository signUpRepository;

	@Autowired
	EmailService emailService;

	@Override
	public boolean saveSignUpDetails(SignUp signUp) {
		boolean isSend = false;
		SignUp userFound = signUpRepository.findByEmail(signUp.getEmail());
		if (userFound != null) {
			return false;
		}
		int otp = GenericUtils.generatePin();
		signUp.setSignUpOtp(otp);
		SignUp savedUser = signUpRepository.save(signUp);
		if (savedUser != null) {
			isSend = emailService.sendSimpleMessage(savedUser.getEmail(), "Verify OTP", "Your otp is :   " + otp);
		}
		return savedUser != null && isSend;
	}

	@Override
	public boolean verifyUserEmail(int otp, String verifyEmail) {
		SignUp userFound = signUpRepository.findBySignUpOtp(otp);
		if (userFound!=null && userFound.getSignUpOtp() == otp) {
			userFound.setSignUpOtp(0);
			userFound.setUserVarified(true);
			SignUp isVerified = signUpRepository.save(userFound);
			if (isVerified != null) {
				return true;
			}
		}
		return false;
	}
}
