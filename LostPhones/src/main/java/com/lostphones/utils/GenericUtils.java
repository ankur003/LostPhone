package com.lostphones.utils;

import java.util.Random;

public class GenericUtils {
	private static final Random generator = new Random();

	private GenericUtils() {

	}

	public static int generatePin() {
		return 100000 + generator.nextInt(900000);
	}

	public static boolean sendVarificationEmail(int otp, String userEmail) {
		return true;
	}
}
