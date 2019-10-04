package com.school.portal.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.portal.domain.app.LoginCountConfig;
import com.school.portal.enums.ErrorCode;
import com.school.portal.enums.ResponseCode;
import com.school.portal.service.app.AppService;
import com.school.portal.utils.ResponseHandler;

import io.swagger.annotations.Api;

@Api
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class AppController {

	@Autowired
	AppService appService;

	@PostMapping(value = "/addLoginCount")
	public ResponseEntity<Object> addLoginCount(@RequestParam("loginCount") Integer loginCount,
			@RequestParam("isLoginCountActive") boolean isLoginCountActive) {

		LoginCountConfig appConfig = appService.updateLoginCount(loginCount, isLoginCountActive);
		if (appConfig == null) {
			return ResponseHandler.response(HttpStatus.INTERNAL_SERVER_ERROR, true, "To many Record Found ",
					ErrorCode.ERROR, ResponseCode.ACKNOWLEDGE_WITHOUT_RESPONSE_OBJECT);
		}
		return ResponseHandler.response(HttpStatus.OK, true, "Login Count Updated", ErrorCode.OK,
				ResponseCode.ACKNOWLEDGE, appConfig);

	}
}
