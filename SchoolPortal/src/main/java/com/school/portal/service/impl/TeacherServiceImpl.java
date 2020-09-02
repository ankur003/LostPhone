package com.school.portal.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.portal.domain.ClassDetail;
import com.school.portal.domain.Role;
import com.school.portal.domain.SectionNames;
import com.school.portal.domain.User;
import com.school.portal.dto.CreateTeacherForm;
import com.school.portal.enums.RoleEum;
import com.school.portal.enums.UserType;
import com.school.portal.repo.RoleRepo;
import com.school.portal.repo.UserRepo;
import com.school.portal.service.TeacherService;
import com.school.portal.service.UserService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	UserService userService;
	
	@Autowired
	RoleRepo roleRepo;

	@Override
	public boolean checkAlreadyExist(CreateTeacherForm createTeacherForm) {
		return userRepo.findByUsernameAndIsActive(createTeacherForm.getEmail(), true) != null;
	}

	@Override
	public User createTeacher(CreateTeacherForm createTeacherForm) {
		try {
			User user = new User();
			user.setActive(true);
			user.setAdmin(false);
//		user.setDob(createTeacherForm.getDob());
//		user.setDoj(createTeacherForm.getDoj());
			user.setName(createTeacherForm.getTeacherName());
			user.setUsername(createTeacherForm.getEmail());
			user.setUserType(UserType.TEACHER);
			setSectionAndClassDetails(user, createTeacherForm);
			
			Set<Role> roleAssignToBeUser = new HashSet<>();
			Role role = roleRepo.findByName(RoleEum.TEACHER.name());
			roleAssignToBeUser.add(role);
			user.setRoles(roleAssignToBeUser);
			
			
//			Set<RoleEum> roles = new HashSet<>();
//			RoleEum role = new RoleEum();
//			role.setDescription("TEACHER role for the TEACHER");
//			role.setName(com.school.portal.enums.RoleEum.TEACHER.name());
//			roles.add(role);
//			user.setRoles(roles);
			user = userRepo.save(user);
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	private User setSectionAndClassDetails(User user, CreateTeacherForm createTeacherForm) {
		if (createTeacherForm.isClassTeacher()) {
			Set<String> classNames = createTeacherForm.getTeacherClassSectionMap().keySet();
			Set<ClassDetail> setOfClassNames = new HashSet<>();
			for (String classNameInString : classNames) {
				ClassDetail className = new ClassDetail();
				className.setClassName(classNameInString);
				className.setUser(user);
				Set<String> sectionSetInString = createTeacherForm.getTeacherClassSectionMap().get(classNameInString);
				if (sectionSetInString != null && !sectionSetInString.isEmpty()) {
					Set<SectionNames> set = getSectionSet(className, sectionSetInString);
					className.setSectionNames(set);
				}
				setOfClassNames.add(className);
			}
			user.setClassNames(setOfClassNames);
		}
		return user;
	}

	private Set<SectionNames> getSectionSet(ClassDetail className, Set<String> sectionSetInString) {
		Set<SectionNames> set = new HashSet<>();
		for (String sectionName : sectionSetInString) {
			SectionNames section = new SectionNames();
			section.setClassNames(className);
			section.setSectionName(sectionName);
			set.add(section);
		}
		return set;
	}
}
