package com.school.portal.service;

import java.util.List;

import com.school.portal.domain.app.ClassMaster;

public interface ClassSectionService {

	List<ClassMaster> getAllSectionClass();
	
	ClassMaster getClassMaster(String className);

}
