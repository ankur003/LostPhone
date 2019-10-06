package com.school.portal.service;

import com.school.portal.domain.User;
import com.school.portal.dto.LoginUser;
import com.school.portal.enums.LoginAttempt;

public interface UserService {

	public User checkCredaintials(LoginUser loginUser);

	public User getUser(String userEmail);

	public boolean assignOrRemoveRole(User user, String roleName, Boolean isAssign);

	public int checkAndUpdateLoginAtemptCount(User user, LoginAttempt loginAttempt);

}
