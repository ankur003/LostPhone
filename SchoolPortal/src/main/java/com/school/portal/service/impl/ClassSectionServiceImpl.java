package com.school.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.portal.domain.ClassMaster;
import com.school.portal.repo.ClassMasterRepo;
import com.school.portal.service.ClassSectionService;

@Service
public class ClassSectionServiceImpl implements ClassSectionService {

	@Autowired ClassMasterRepo classMasterRepo;
	
	@Override
	public List<ClassMaster> getAllSectionClass() {
		return classMasterRepo.findAll();
	}

}
