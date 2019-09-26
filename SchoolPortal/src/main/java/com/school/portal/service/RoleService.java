package com.school.portal.service;

import com.school.portal.enums.Role;

public interface RoleService {

	boolean checkRole(Role roleName);

	com.school.portal.domain.Role addRole(Role roleName, String roleDesc);

}
