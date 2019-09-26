package com.school.portal.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.portal.domain.ClassMaster;
import com.school.portal.domain.SectionMaster;
import com.school.portal.dto.SectionClassDto;
import com.school.portal.enums.ErrorCode;
import com.school.portal.enums.ResponseCode;
import com.school.portal.service.SectionClassService;
import com.school.portal.utils.ErrorCollectionUtil;
import com.school.portal.utils.ResponseBuildUtility;
import com.school.portal.utils.ResponseHandler;
import com.school.portal.utils.Utils;

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
		if (Objects.isNull(createdClassDetails)) {
			return ResponseHandler.response(HttpStatus.BAD_REQUEST, true,
					"Update Activity Detected, Go to update class and section", ErrorCode.ERROR,
					ResponseCode.ACKNOWLEDGE_WITHOUT_RESPONSE_OBJECT);
		}
		Map<String, Object> createdClassResponseMap = ResponseBuildUtility.buildClassResponse(createdClassDetails);
		return ResponseHandler.response(HttpStatus.OK, false, "Class Created Successfully", ErrorCode.OK,
				ResponseCode.ACKNOWLEDGE, createdClassResponseMap);
	}

	@GetMapping(value = "/getAllClassAndSections")
	public ResponseEntity<Object> getAllClassAndSections() {
		List<ClassMaster> classDetailsList = sectionClassService.getAllClassAndSections();
		LOGGER.info("classMaster ===== > {}", classDetailsList);
		Map<String, Object> classResponseMap = ResponseBuildUtility.buildClassResponse(classDetailsList);
		return ResponseHandler.response(HttpStatus.OK, false, "Class and Section Retrieved Successfully", ErrorCode.OK,
				ResponseCode.ACKNOWLEDGE, classResponseMap);
	}

	@PreAuthorize("hasRole('ADMIN')")
	//////@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping(value = "/getAllEnableClassAndSections")
	public ResponseEntity<Object> getAllEnableClassAndSections() {
		List<ClassMaster> classDetailsList = sectionClassService.getAllClassAndSections();
		LOGGER.info("classMaster ===== > {}", classDetailsList);
		Map<String, Object> classResponseMap = ResponseBuildUtility
				.buildEnableClassAndSectionResponse(classDetailsList);
		return ResponseHandler.response(HttpStatus.OK, false, "Class and Section Retrieved Successfully", ErrorCode.OK,
				ResponseCode.ACKNOWLEDGE, classResponseMap);
	}

	@GetMapping(value = "/getSectionsListByClassName")
	public ResponseEntity<Object> getSectionsListByClassName(
			@NotBlank(message = "className is missing or null ") @RequestParam("className") String className) {
		ClassMaster classDetails = sectionClassService.getSectionsListByClassName(className);
		LOGGER.info("classMaster getSectionsListByClassName ===== > {}", classDetails);
		if (classDetails == null) {
			return ResponseHandler.response(HttpStatus.BAD_REQUEST, true, "Class Not Found", ErrorCode.ERROR,
					ResponseCode.ACKNOWLEDGE_WITHOUT_RESPONSE_OBJECT);
		}
		Map<String, Object> classResponseMap = ResponseBuildUtility.buildClassResponse(classDetails);
		return ResponseHandler.response(HttpStatus.OK, false, "Class Retrieved Successfully", ErrorCode.OK,
				ResponseCode.ACKNOWLEDGE, classResponseMap);
	}

	@DeleteMapping(value = "/deleteClass")
	public ResponseEntity<Object> deleteClass(
			@NotBlank(message = "className is missing or null ") @RequestParam("className") String className) {

		ClassMaster classMaster = sectionClassService.checkIsClassExists(className, true);
		if (Objects.nonNull(classMaster)) {
			ClassMaster updatedClassMaster = sectionClassService.disableClassAndSections(classMaster);
			Map<String, Object> createdClassResponseMap = ResponseBuildUtility.buildClassResponse(updatedClassMaster);
			return ResponseHandler.response(HttpStatus.OK, false, "Class Deleted Successfully", ErrorCode.OK,
					ResponseCode.ACKNOWLEDGE, createdClassResponseMap);
		}
		return ResponseHandler.response(HttpStatus.BAD_REQUEST, false, "Class Not Exists ", ErrorCode.ERROR,
				ResponseCode.ACKNOWLEDGE_WITHOUT_RESPONSE_OBJECT);
	}

	@DeleteMapping(value = "/deleteSectionOfClass")
	public ResponseEntity<Object> deleteSectionOfClass(
			@NotBlank(message = "className is missing or null ") @RequestParam("className") String className,
			@NotBlank(message = "classSectionName is missing or null ") @RequestParam("sectionName") String sectionName) {

		ClassMaster classMaster = sectionClassService.checkIsClassExists(className, true);
		if (Objects.isNull(classMaster)) {
			return ResponseHandler.response(HttpStatus.BAD_REQUEST, false, "Class Not Exists", ErrorCode.ERROR,
					ResponseCode.ACKNOWLEDGE_WITHOUT_RESPONSE_OBJECT);
		}
		List<SectionMaster> sectionList = classMaster.getSectionMaster();
		boolean isSectionExists = Utils.checkIsSectionExistsInClass(sectionList, sectionName);
		if (isSectionExists) {
			classMaster = sectionClassService.disablePurticularSection(classMaster, sectionName);
			Map<String, Object> classResponseMap = ResponseBuildUtility.buildClassResponse(classMaster);
			return ResponseHandler.response(HttpStatus.OK, false, "Section Deleted Successfully", ErrorCode.OK,
					ResponseCode.ACKNOWLEDGE, classResponseMap);
		}
		return ResponseHandler.response(HttpStatus.BAD_REQUEST, false, "Section does not exists in Class",
				ErrorCode.ERROR, ResponseCode.ACKNOWLEDGE_WITHOUT_RESPONSE_OBJECT);
	}

	@PutMapping(value = "/enableClass")
	public ResponseEntity<Object> enableClass(
			@NotBlank(message = "className is missing or null ") @RequestParam("className") String className) {

		ClassMaster classMaster = sectionClassService.checkIsClassExists(className, false);
		if (Objects.nonNull(classMaster)) {
			ClassMaster updatedClassMaster = sectionClassService.enableClass(classMaster);
			Map<String, Object> createdClassResponseMap = ResponseBuildUtility.buildClassResponse(updatedClassMaster);
			return ResponseHandler.response(HttpStatus.OK, false, "Class Enabled Successfully", ErrorCode.OK,
					ResponseCode.ACKNOWLEDGE, createdClassResponseMap);
		}
		return ResponseHandler.response(HttpStatus.BAD_REQUEST, false, "Class Not Exists", ErrorCode.ERROR,
				ResponseCode.ACKNOWLEDGE_WITHOUT_RESPONSE_OBJECT);
	}

	@PutMapping(value = "/enableSections")
	public ResponseEntity<Object> enableSections(
			@NotBlank(message = "className is missing or null ") @RequestParam("className") String className,
			@NotBlank(message = "Section Name list iis missing or null ") @RequestParam("sectionNames") List<String> sectionNames) {

		ClassMaster classMaster = sectionClassService.checkIsClassExists(className, true);
		if (Objects.nonNull(classMaster)) {
			ClassMaster updatedClassMaster = sectionClassService.enableSections(classMaster, sectionNames);
			Map<String, Object> createdClassResponseMap = ResponseBuildUtility.buildClassResponse(updatedClassMaster);
			return ResponseHandler.response(HttpStatus.OK, false, "Class Enabled Successfully", ErrorCode.OK,
					ResponseCode.ACKNOWLEDGE, createdClassResponseMap);
		}
		return ResponseHandler.response(HttpStatus.BAD_REQUEST, false, "Create or enable class first", ErrorCode.ERROR,
				ResponseCode.ACKNOWLEDGE_WITHOUT_RESPONSE_OBJECT);
	}

}
