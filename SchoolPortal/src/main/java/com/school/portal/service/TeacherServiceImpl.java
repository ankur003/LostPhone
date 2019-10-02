package com.school.portal.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.portal.domain.Role;
import com.school.portal.domain.User;
import com.school.portal.dto.CreateTeacherForm;
import com.school.portal.enums.UserType;
import com.school.portal.repo.UserRepo;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	RoleService roleService;

	@Override
	public boolean checkAlreadyExist(CreateTeacherForm createTeacherForm) {
		return userRepo.findByUsernameAndIsActive(createTeacherForm.getEmail(), true) != null;
	}

	@Override
	public User createTeacher(CreateTeacherForm createTeacherForm) {
		User user = new User();
		user.setActive(true);
		user.setAdmin(false);
		user.setClassName(createTeacherForm.getClassName());
		user.setSectionName(createTeacherForm.getSectionName());
		user.setDob(createTeacherForm.getDob());
		user.setDoj(createTeacherForm.getDoj());
		user.setName(createTeacherForm.getTeacherName());
		user.setUsername(createTeacherForm.getEmail());
		user.setUserType(UserType.TEACHER.name());
		if (checkRole()) {
			user.setRoles(setRole());
			return userRepo.save(user);
		}ff
		return null;
	}

	private boolean checkRole() {
		return roleService.checkRole(com.school.portal.enums.Role.TEACHER);
	}

	private Set<Role> setRole() {
		Set<Role> roles = new HashSet<>();
		Role role = new Role();
		role.setDescription("Teacher role");
		role.setName(com.school.portal.enums.Role.TEACHER.name());
		roles.add(role);
		return roles;
	}
}
