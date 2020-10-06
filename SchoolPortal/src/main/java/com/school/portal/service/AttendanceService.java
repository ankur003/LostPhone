package com.school.portal.service;

import java.util.List;

import com.school.portal.domain.Attendance;
import com.school.portal.domain.User;
import com.school.portal.model.request.UserAttendanceRequestModel;

public interface AttendanceService {

	List<Attendance> getUserAttendance(User user, UserAttendanceRequestModel userAttendanceRequestModel);

}
