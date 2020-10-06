package com.school.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.portal.domain.User;
import com.school.portal.enums.AcademicYear;
import com.school.portal.repo.UserRepo;
import com.school.portal.service.EntityService;

@Service
public class EntityServiceImpl implements EntityService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public User getUser(String userUuid) {
		return userRepo.findByUserUuidAndAcademicYearAndIsActive(userUuid, AcademicYear.YEAR_2020_2021, true);
	}

}
