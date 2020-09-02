package com.school.portal.controller.app;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.portal.domain.app.Holidays;
import com.school.portal.domain.app.LoginCount;
import com.school.portal.enums.ErrorCode;
import com.school.portal.enums.ResponseCode;
import com.school.portal.service.app.AppService;
import com.school.portal.utils.ResponseBuilder;

import io.swagger.annotations.Api;

@Api
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class AppController {

	@Autowired
	private AppService appService;

	@PutMapping(value = "/loginCount")
	public ResponseEntity<Object> addOrUpdateLoginCount(@RequestParam("loginCount") Integer loginCount,
			@RequestParam("isLoginCountActive") boolean isLoginCountActive) {
		LoginCount appConfig = appService.updateLoginCount(loginCount, isLoginCountActive);
		return ResponseBuilder.response(HttpStatus.OK, false, "Login Count Updated", ErrorCode.OK,
				ResponseCode.ACKNOWLEDGE, appConfig);
	}

	@PostMapping(value = "/add/holidays")
	public ResponseEntity<Object> addHolidays(@RequestBody Map<String, String> holiDayMap) {
		if (holiDayMap == null || holiDayMap.isEmpty()) {
			return ResponseBuilder.response(HttpStatus.BAD_REQUEST, true, "No Data to add", ErrorCode.ERROR,
					ResponseCode.ACKNOWLEDGE_WITHOUT_RESPONSE_OBJECT);
		}
		List<Holidays> addedHolidaysList = appService.addHolidays(holiDayMap);
		if (addedHolidaysList == null) {
			return ResponseBuilder.response(HttpStatus.BAD_REQUEST, true, "Data already exist", ErrorCode.ERROR,
					ResponseCode.ACKNOWLEDGE_WITHOUT_RESPONSE_OBJECT);
		}
		return ResponseBuilder.response(HttpStatus.OK, false, "Holidays Added", ErrorCode.OK, ResponseCode.ACKNOWLEDGE,
				addedHolidaysList);
	}

}
