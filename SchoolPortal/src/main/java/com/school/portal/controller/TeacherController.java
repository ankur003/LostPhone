package com.school.portal.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.portal.domain.User;
import com.school.portal.dto.CreateTeacherForm;
import com.school.portal.enums.ErrorCode;
import com.school.portal.enums.ResponseCode;
import com.school.portal.enums.Role;
import com.school.portal.service.RoleService;
import com.school.portal.service.TeacherService;
import com.school.portal.utils.ErrorCollectionUtil;
import com.school.portal.utils.ResponseHandler;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("/admin")
public class TeacherController {

	@Autowired
	TeacherService teacherService;

	@Autowired
	RoleService roleService;

	private static final Logger LOGGER = LoggerFactory.getLogger(TeacherController.class);

	@PostMapping(value = "/createTeacher")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> createTeacher(@Valid @RequestBody CreateTeacherForm createTeacherForm,
			@RequestHeader("Authorization") String authorization, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.response(HttpStatus.BAD_REQUEST, true, ErrorCollectionUtil.getError(bindingResult),
					ErrorCode.ERROR, ResponseCode.ACKNOWLEDGE_OPTIONAL_RESPONSE_OBJECT,
					ErrorCollectionUtil.getErrorMap(bindingResult));
		}
		boolean isExist = teacherService.checkAlreadyExist(createTeacherForm);
		LOGGER.info("isExist--->>>  {}", isExist);
		if (isExist) {
			return ResponseHandler.response(HttpStatus.BAD_REQUEST, true, "Teacher Already Exist", ErrorCode.ERROR,
					ResponseCode.ACKNOWLEDGE_WITHOUT_RESPONSE_OBJECT);
		}

		boolean isRoleExist = roleService.checkRole(Role.TEACHER);
		if (!isRoleExist) {
			return ResponseHandler.response(HttpStatus.BAD_REQUEST, true, "Create Teacher Role first", ErrorCode.ERROR,
					ResponseCode.ACKNOWLEDGE_WITHOUT_RESPONSE_OBJECT);
		}
		User teacher = teacherService.createTeacher(createTeacherForm);
		if (teacher == null) {
			return ResponseHandler.response(HttpStatus.INTERNAL_SERVER_ERROR, true, "Teacher creation failed",
					ErrorCode.ERROR, ResponseCode.ACKNOWLEDGE_WITHOUT_RESPONSE_OBJECT);
		}
		return ResponseHandler.response(HttpStatus.OK, false, "Teacher Created Successfully", ErrorCode.OK,
				ResponseCode.ACKNOWLEDGE, teacher.getName());
	}
}
