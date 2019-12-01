package com.school.portal.service;

import com.school.portal.enums.RoleEum;

public interface RoleService {

	boolean checkRole(RoleEum roleName);

	com.school.portal.domain.Role addRole(RoleEum roleName, String roleDesc);

}
