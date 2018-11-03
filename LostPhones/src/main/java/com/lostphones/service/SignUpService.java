package com.lostphones.service;

import com.lostphones.model.SignUp;

public interface SignUpService {

	public boolean saveSignUpDetails(SignUp signUp);

	public boolean verifyUserEmail(int otp, String verifyEmail);
}
