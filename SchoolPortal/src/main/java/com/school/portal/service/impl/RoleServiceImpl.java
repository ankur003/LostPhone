package com.school.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.portal.enums.RoleEum;
import com.school.portal.repo.RoleRepo;
import com.school.portal.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepo roleRepo;

	@Override
	public boolean checkRole(RoleEum roleName) {
		return roleRepo.findByName(roleName.name()) != null;
	}

	@Override
	public com.school.portal.domain.Role addRole(RoleEum roleName, String roleDesc) {
		com.school.portal.domain.Role role = new com.school.portal.domain.Role();
		role.setDescription(roleDesc == null ? "RoleEum Description" : roleDesc);
		role.setName(roleName);
		return roleRepo.save(role);
	}
}
