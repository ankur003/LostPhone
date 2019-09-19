package com.school.portal.controller.sectionclasscontroller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.portal.dto.SectionClassDto;
import com.school.portal.service.sectionclass.SectionClassService;

@RestController
public class SectionClassController {
	
	@Autowired
	SectionClassService sectionClassService;

	private static final Logger LOGGER = LoggerFactory.getLogger(SectionClassController.class);

	@PostMapping(value = "")
	public ResponseEntity<Object> createSectionAndClass(@Valid @RequestBody SectionClassDto sectionClassDto) {
		return null;

	}

}
