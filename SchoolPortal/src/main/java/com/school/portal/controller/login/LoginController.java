package com.school.portal.controller.login;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.portal.domain.User;
import com.school.portal.dto.LoginUser;
import com.school.portal.enums.ErrorCode;
import com.school.portal.enums.ResponseCode;
import com.school.portal.service.AuthenticationService;
import com.school.portal.service.UserService;
import com.school.portal.utils.ResponseBuildUtility;
import com.school.portal.utils.ResponseHandler;

import io.swagger.annotations.Api;

@Api
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class LoginController {

	@Autowired
	AuthenticationService authenticationService;

	@Autowired
	UserService userService;

	@PostMapping(value = "/login")
	public ResponseEntity<Object> login(@RequestBody LoginUser loginUser) {
		User user = userService.checkCredaintials(loginUser);
		if (Objects.isNull(user)) {
			return ResponseHandler.response(HttpStatus.BAD_REQUEST, true, "Incorrect Details", ErrorCode.ERROR,
					ResponseCode.ACKNOWLEDGE_WITHOUT_RESPONSE_OBJECT);
		}
		String jwtToken = authenticationService.login(loginUser);
		Map<String, Object> map = ResponseBuildUtility.buildLoginResponse(jwtToken, user);
		return ResponseHandler.response(HttpStatus.OK, false, "Login Success", ErrorCode.OK, ResponseCode.ACKNOWLEDGE,
				map);
	}
}
