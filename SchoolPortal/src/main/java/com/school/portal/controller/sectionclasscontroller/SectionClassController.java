package com.school.portal.controller.sectionclasscontroller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.portal.dto.SectionClassDto;
import com.school.portal.enums.ErrorCode;
import com.school.portal.enums.ResponseCode;
import com.school.portal.service.sectionclass.SectionClassService;
import com.school.portal.utils.ErrorCollectionUtil;
import com.school.portal.utils.ResponseHandler;

import io.swagger.annotations.Api;

@Api
@RestController
public class SectionClassController {

	@Autowired
	SectionClassService sectionClassService;

	private static final Logger LOGGER = LoggerFactory.getLogger(SectionClassController.class);

	@PostMapping(value = "/save")
	public ResponseEntity<Object> createSectionAndClass(@Valid @RequestBody SectionClassDto sectionClassDto,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.response(HttpStatus.BAD_REQUEST, true, ErrorCollectionUtil.getError(bindingResult),
					ErrorCode.ERROR, ResponseCode.ACKNOWLEDGE_OPTIONAL_RESPONSE_OBJECT,
					ErrorCollectionUtil.getErrorMap(bindingResult));
		}

		boolean isAlreadyCreated = sectionClassService.checkAlreadyCreatedClassOrSection(sectionClassDto);

		return ResponseHandler.response(HttpStatus.BAD_REQUEST, true, "", ErrorCode.ERROR,
				ResponseCode.ACKNOWLEDGE_WITHOUT_RESPONSE_OBJECT, isAlreadyCreated);

	}

}
