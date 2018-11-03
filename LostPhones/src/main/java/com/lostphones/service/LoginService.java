package com.lostphones.service;

import com.lostphones.dto.LoginDto;
import com.lostphones.model.SignUp;

public interface LoginService {

	SignUp checkLogin(LoginDto login);

	Boolean findByEmail(String forgotPassEmail);

	Boolean sendMailForgotPass(String email);

	Boolean findByForgotPasswordOtp(int forgotPasswordOtp , String password); 

}
