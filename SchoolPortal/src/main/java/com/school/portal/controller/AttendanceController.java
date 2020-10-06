package com.school.portal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.portal.domain.Attendance;
import com.school.portal.domain.User;
import com.school.portal.model.request.UserAttendanceRequestModel;
import com.school.portal.model.response.AttendanceModel;
import com.school.portal.service.AttendanceService;
import com.school.portal.service.EntityService;
import com.school.portal.utils.ResponseBuilder;
import com.school.portal.utils.ValidUuid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/v1/user")
public class AttendanceController extends AbstractController {

	@Autowired
	private AttendanceService attendanceService;
	
	@Autowired 
	private EntityService entityService;

	@ApiOperation(value = "Get User Attendance", notes = "if `specificDate` is provided then seach criteria will work only on it.")
	@GetMapping(value = "/attendance/{userUuid}")
	public ResponseEntity<Object> getUserAttendance(
			@ApiParam(value = "User Unique Id", required = true) @ValidUuid(message = "userUuid is missing") @PathVariable("userUuid") final String userUuid,
			@Valid @ModelAttribute final UserAttendanceRequestModel userAttendanceRequestModel) {
		final User user = entityService.getUser(userUuid);
		if(user == null) {
			return null;
		}
		List<Attendance> attendances = attendanceService.getUserAttendance(user, userAttendanceRequestModel);
		return ResponseBuilder.getApiBaseContentResponseAsList(beanMapper, attendances, AttendanceModel.class);
	}

}
