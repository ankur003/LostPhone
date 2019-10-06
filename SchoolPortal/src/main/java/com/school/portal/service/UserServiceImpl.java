package com.school.portal.service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.school.portal.domain.User;
import com.school.portal.dto.LoginUser;
import com.school.portal.enums.LoginAttempt;
import com.school.portal.repo.UserRepo;
import com.school.portal.service.app.AppService;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	AppService appService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public UserDetails loadUserByUsername(String username) {
		User user = userRepo.findByUsernameAndIsActive(username, true);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthority(user));
	}

	private Set<SimpleGrantedAuthority> getAuthority(User user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		});
		return authorities;
	}

	@Override
	public User checkCredaintials(LoginUser loginUser) {
		User user = userRepo.findByUsernameAndIsActive(loginUser.getUsername(), true);
		if (Objects.isNull(user)) {
			return null;
		}
		boolean isValid = encoder.matches(loginUser.getPassword(), user.getPassword());
		if (isValid) {
			return user;
		}
		return null;
	}

	@Override
	public User getUser(String userEmail) {
		return userRepo.findByUsernameAndIsActive(userEmail, true);
	}

	@Override
	public boolean assignOrRemoveRole(User user, String roleName, Boolean isAssign) {
		Set<com.school.portal.domain.Role> roleSet = user.getRoles();
		if (isAssign) {
			for (com.school.portal.domain.Role role : roleSet) {
				if (role.getName().equalsIgnoreCase(roleName)) {
					return false;
				}
			}
			com.school.portal.domain.Role role = new com.school.portal.domain.Role();
			role.setName(roleName);
			return userRepo.save(user) != null;
		}
		for (com.school.portal.domain.Role role : roleSet) {
			if (role.getName().equalsIgnoreCase(roleName)) {
				roleSet.remove(role);
				return userRepo.save(user) != null;
			}
		}
		return false;
	}

	@Override
	public int checkAndUpdateLoginAtemptCount(User loginUser, LoginAttempt loginAttempt) {
		if (loginUser == null) {
			return 0;
		}
		int countSetByAdmin = getLoginAtemptCountSetByAdmin();
		if (countSetByAdmin == 0) {
			return countSetByAdmin;
		}
		int attemptedLoginCount = loginUser.getFailureLoginCount();
		if (loginAttempt == LoginAttempt.SUCCESS) {
			if (attemptedLoginCount != 0) {
				loginUser.setFailureLoginCount(0);
			}
		}
		if (loginAttempt == LoginAttempt.FAILURE) {
			if (attemptedLoginCount >= countSetByAdmin) {
				loginUser.setBlocked(true);
			} else {
				loginUser.setFailureLoginCount(attemptedLoginCount++);
			}
		}
		userRepo.save(loginUser);
		return countSetByAdmin;
	}

	private int getLoginAtemptCountSetByAdmin() {
		return appService.getLoginCount();
	}
}
