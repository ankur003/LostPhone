package com.school.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.portal.domain.app.ClassMaster;
import com.school.portal.service.ClassSectionService;
import com.school.portal.utils.ResponseBuilder;

import io.swagger.annotations.Api;

@Api
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class ClassSectionController extends AbstractController {

	@Autowired
	private ClassSectionService classSectionService;

	@GetMapping(value = "/class-section")
	public ResponseEntity<Object> getAllSectionClass() {
		final List<ClassMaster> classMasters = classSectionService.getAllSectionClass();
		return ResponseBuilder.getClassSectionResponse(classMasters);
		// return ResponseBuilder.getApiBaseContentResponseAsList(beanMapper,
		// classMasters, ClassMasterModel.class);
	}
}
