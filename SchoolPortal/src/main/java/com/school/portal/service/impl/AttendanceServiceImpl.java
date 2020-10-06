package com.school.portal.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.portal.domain.Attendance;
import com.school.portal.domain.User;
import com.school.portal.enums.AcademicYear;
import com.school.portal.model.request.UserAttendanceRequestModel;
import com.school.portal.repo.AttendanceRepo;
import com.school.portal.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired
	private AttendanceRepo attendanceRepo;

	@Override
	public List<Attendance> getUserAttendance(User user, UserAttendanceRequestModel userAttendanceRequestModel) {
		if (userAttendanceRequestModel.getSpecificDate() != null) {
			return attendanceRepo.findByUserAndAbsentDateAndAcademicYear(user,
					LocalDate.parse(userAttendanceRequestModel.getSpecificDate()), AcademicYear.YEAR_2020_2021);
		}
		return attendanceRepo.findAllByAbsentDateBetweenAndUserAndAcademicYear(LocalDate.parse(userAttendanceRequestModel.getStartDate()),
				LocalDate.parse(userAttendanceRequestModel.getEndDate()), user, AcademicYear.YEAR_2020_2021);
	}

}
