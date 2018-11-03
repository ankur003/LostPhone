package com.lostphones.utils;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class PasswordEncoderUtil {

	private static BCryptPasswordEncoder passwordEncoder = null;

	@Value("${lostphones.tokensecret}")
	private static String secret;

	public String encode(CharSequence rawPassword) {
		if (passwordEncoder == null)
			create();
		return passwordEncoder.encode(rawPassword);
	}

	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		if (passwordEncoder == null)
			create();
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}

	private static void create() {
		passwordEncoder = new BCryptPasswordEncoder(4, new SecureRandom(secret.getBytes()));
	}
}
