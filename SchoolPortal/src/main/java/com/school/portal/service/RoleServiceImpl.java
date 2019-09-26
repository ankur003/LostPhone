package com.school.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.portal.enums.Role;
import com.school.portal.repo.RoleRepo;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepo roleRepo;

	@Override
	public boolean checkRole(Role roleName) {
		return roleRepo.findByName(roleName.name()) != null;
	}

	@Override
	public com.school.portal.domain.Role addRole(Role roleName, String roleDesc) {
		com.school.portal.domain.Role role = new com.school.portal.domain.Role();
		role.setDescription(roleDesc == null ? "Role Description" : roleDesc);
		role.setName(roleName.name());
		return roleRepo.save(role);
	}
}
