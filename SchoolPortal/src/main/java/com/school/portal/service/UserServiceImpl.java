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
import com.school.portal.repo.UserRepo;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	UserRepo userRepo;

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
}
