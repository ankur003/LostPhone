package com.school.portal.controller.sectionclasscontroller;

import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.portal.domain.ClassMaster;
import com.school.portal.dto.SectionClassDto;
import com.school.portal.enums.ErrorCode;
import com.school.portal.enums.ResponseCode;
import com.school.portal.service.sectionclass.SectionClassService;
import com.school.portal.utils.ErrorCollectionUtil;
import com.school.portal.utils.ResponseBuildUtility;
import com.school.portal.utils.ResponseHandler;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("/admin")
public class SectionClassController {

	@Autowired
	SectionClassService sectionClassService;

	private static final Logger LOGGER = LoggerFactory.getLogger(SectionClassController.class);

	@PostMapping(value = "/createClassAndSection")
	public ResponseEntity<Object> createSectionAndClass(@Valid @RequestBody SectionClassDto sectionClassDto,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.response(HttpStatus.BAD_REQUEST, true, ErrorCollectionUtil.getError(bindingResult),
					ErrorCode.ERROR, ResponseCode.ACKNOWLEDGE_OPTIONAL_RESPONSE_OBJECT,
					ErrorCollectionUtil.getErrorMap(bindingResult));
		}
		ClassMaster createdClassDetails = sectionClassService.checkAlreadyCreatedClassOrSectionAndSave(sectionClassDto);
		LOGGER.info("classMaster ===== > {}", createdClassDetails);
		Map<String, Object> createdClassResponseMap = ResponseBuildUtility
				.buildCreatedClassResponse(createdClassDetails);
		return ResponseHandler.response(HttpStatus.BAD_REQUEST, false, "Class Created Successfully", ErrorCode.OK,
				ResponseCode.ACKNOWLEDGE_WITHOUT_RESPONSE_OBJECT, createdClassResponseMap);
	}

	@PostMapping(value = "/deleteClass")
	public ResponseEntity<Object> deleteClass(
			@NotBlank(message = "className is missing or null ") @RequestParam("className") String className) {

		ClassMaster classMaster = sectionClassService.checkIsClassExists(className);
		if (Objects.nonNull(classMaster)) {
			ClassMaster updatedClassMaster = sectionClassService.disableClassAndSection(classMaster);
			return ResponseHandler.response(HttpStatus.OK, false, "Class Deleted Successfully", ErrorCode.OK,
					ResponseCode.ACKNOWLEDGE_WITHOUT_RESPONSE_OBJECT, updatedClassMaster);
		}
		return ResponseHandler.response(HttpStatus.BAD_REQUEST, false, "Class Not Exists", ErrorCode.ERROR,
				ResponseCode.ACKNOWLEDGE_WITHOUT_RESPONSE_OBJECT);
	}

}
