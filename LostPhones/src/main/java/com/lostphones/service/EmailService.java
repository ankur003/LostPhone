package com.lostphones.service;

public interface EmailService {

	boolean sendSimpleMessage(String to, String subject, String text);

}
