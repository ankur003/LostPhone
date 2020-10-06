package com.school.portal.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.portal.domain.app.Holidays;
import com.school.portal.enums.AcademicYear;
import com.school.portal.repo.app.HolidaysRepo;
import com.school.portal.service.HolidayService;

@Service
public class HolidayServiceImpl implements HolidayService{
	
	@Autowired
	private HolidaysRepo holidaysRepo;

	@Override
	public Holidays getHolidayDetails(String holidayDate) {
		return holidaysRepo.findByHolidayDateAndAcademicYear(LocalDate.parse(holidayDate), AcademicYear.YEAR_2020_2021);
	}

}
