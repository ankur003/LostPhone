package com.school.portal.controller;

import java.util.Objects;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.portal.domain.User;
import com.school.portal.enums.ErrorCode;
import com.school.portal.enums.ResponseCode;
import com.school.portal.enums.Role;
import com.school.portal.service.RoleService;
import com.school.portal.service.UserService;
import com.school.portal.utils.LoggedInUserUtil;
import com.school.portal.utils.ResponseHandler;

import io.swagger.annotations.Api;

@Api
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class RoleController {

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@Autowired
	LoggedInUserUtil logedInUserUtil;

	@PutMapping(value = "/assignOrRemoveRole")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> assignRole(@RequestHeader("Authorization") String authorization,
			@NotBlank(message = "userEmail is null") @RequestParam("userEmail") String userEmail,
			@NotBlank(message = "roleName is null") @RequestParam("roleName") Role roleName,
			@NotBlank(message = "isAssign is null") @RequestParam("isAssign") Boolean isAssign) {

		User user = userService.getUser(userEmail);
		if (Objects.isNull(user)) {
			return ResponseHandler.response(HttpStatus.BAD_REQUEST, true, "User not found", ErrorCode.ERROR,
					ResponseCode.ACKNOWLEDGE_WITHOUT_RESPONSE_OBJECT);
		}
		boolean isValid = roleService.checkRole(roleName);
		if (!isValid) {
			return ResponseHandler.response(HttpStatus.BAD_REQUEST, true, "Add Role First into application ",
					ErrorCode.ERROR, ResponseCode.ACKNOWLEDGE);
		}
		boolean isDone = userService.assignOrRemoveRole(user, roleName.name(), isAssign);
		if (isDone) {
			return ResponseHandler.response(HttpStatus.OK, false, "Role Updated", ErrorCode.OK,
					ResponseCode.ACKNOWLEDGE);
		}
		return ResponseHandler.response(HttpStatus.INTERNAL_SERVER_ERROR, true, "Role Already Assigned",
				ErrorCode.ERROR, ResponseCode.ACKNOWLEDGE);
	}

	@PutMapping(value = "/addRole")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> addRoleInApplication(@RequestHeader("Authorization") String authorization,
			@NotBlank(message = "roleName is null") @RequestParam("roleName") Role roleName, String roleDesc) {

		String userEmail = logedInUserUtil.getLoggedInUserName();

		boolean isValid = roleService.checkRole(roleName);
		if (isValid) {
			return ResponseHandler.response(HttpStatus.BAD_REQUEST, true, "Role Already Added", ErrorCode.ERROR,
					ResponseCode.ACKNOWLEDGE);
		}
		com.school.portal.domain.Role role = roleService.addRole(roleName, roleDesc);
		if (Objects.isNull(role)) {
			return ResponseHandler.response(HttpStatus.INTERNAL_SERVER_ERROR, true, "Some Thing went wrong",
					ErrorCode.ERROR, ResponseCode.ACKNOWLEDGE);
		}
		return ResponseHandler.response(HttpStatus.OK, false, "Role Added", ErrorCode.OK, ResponseCode.ACKNOWLEDGE,
				role);
	}
}
