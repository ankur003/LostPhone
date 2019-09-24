package com.school.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.portal.domain.User;
import com.school.portal.enums.ErrorCode;
import com.school.portal.enums.ResponseCode;
import com.school.portal.enums.Role;
import com.school.portal.service.UserService;
import com.school.portal.utils.ResponseHandler;

import io.swagger.annotations.Api;

@Api
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/assignRole")
public class RoleController {
	
	@Autowired
	UserService userService;

	@PutMapping(value = "/giveRole")
	public ResponseEntity<Object> assignRole(@RequestParam("userEmail") String userEmail,
			@RequestParam("roleName") Role roleName) {
		
		//User user = userService.getUser(userEmail);

		return ResponseHandler.response(HttpStatus.OK, false, "Login Success", ErrorCode.OK, ResponseCode.ACKNOWLEDGE,
				"");
	}

}
