package com.school.portal.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.portal.domain.Attendance;
import com.school.portal.domain.User;
import com.school.portal.enums.AcademicYear;
import com.school.portal.model.request.UserAttendanceRequestModel;
import com.school.portal.repo.AttendanceRepo;
import com.school.portal.service.AttendanceService;
import com.school.portal.service.EntityService;

@Service
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired
	private AttendanceRepo attendanceRepo;

	@Autowired
	private EntityService entityService;

	@Override
	public List<Attendance> getUserAttendance(User user, UserAttendanceRequestModel userAttendanceRequestModel) {
		if (userAttendanceRequestModel.getSpecificDate() != null) {
			return attendanceRepo.findByUserAndAbsentDateAndAcademicYear(user,
					LocalDate.parse(userAttendanceRequestModel.getSpecificDate()), AcademicYear.YEAR_2020_2021);
		}
		return attendanceRepo.findAllByAbsentDateBetweenAndUserAndAcademicYear(
				LocalDate.parse(userAttendanceRequestModel.getStartDate()),
				LocalDate.parse(userAttendanceRequestModel.getEndDate()), user, AcademicYear.YEAR_2020_2021);
	}

	@Override
	public Boolean SaveUsersAttendance(Set<String> userUuids, String absentDate) {
		List<Attendance> attendances = new ArrayList<>();
		for (String userUuid : userUuids) {
			User user = entityService.getUser(userUuid);
			if (user != null) {
				Attendance attendance = new Attendance();
				attendance.setUser(user);
				attendance.setAbsentDate(LocalDate.parse(absentDate));
				attendance.setAcademicYear(AcademicYear.YEAR_2020_2021);
				attendance.setCreatedById(null);
				attendance.setIsAbsent(true);
				attendance.setIsActive(true);
				attendances.add(attendance);
			}
		}
		if(attendances.size() == userUuids.size() && CollectionUtils.isNotEmpty(attendances)) {
			attendanceRepo.saveAll(attendances);
			return true;
		}
		return false;
	}
}
