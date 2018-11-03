package com.lostphones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lostphones.model.SignUp;

@Repository
public interface SignUpRepository extends JpaRepository<SignUp, Long> {

	SignUp findByEmail(String email);

	SignUp findByEmailAndPassword(String email, String password);

	SignUp findBySignUpOtp(int otp);
	
	SignUp findByForgotPasswordOtp(int forgotPasswordOtp);
}
