package com.school.portal.config;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.school.portal.domain.Role;
import com.school.portal.domain.User;
import com.school.portal.enums.UserType;
import com.school.portal.repo.UserRepo;

@Component
public class ApplicationConfig {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@PostConstruct
	private void createAdmin() {
		User admin = userRepo.findByUsernameAndIsActive("admin@schoolportal.com", true);
		if (Objects.isNull(admin)) {
			admin = new User();
			admin.setPassword(encoder.encode("admin"));
			Set<Role> roles = new HashSet<>();
			Role role = new Role();
			role.setDescription("Admin role for the principle");
			role.setName(com.school.portal.enums.Role.ADMIN.name());
			roles.add(role);
			admin.setRoles(roles);
			admin.setUsername("admin@schoolportal.com");
			admin.setDoj(new Date());
			admin.setName("principle");
			admin.setUserType(UserType.PRINCIPLE.name());
			admin.setAdmin(true);
			userRepo.save(admin);
		}
	}
}
