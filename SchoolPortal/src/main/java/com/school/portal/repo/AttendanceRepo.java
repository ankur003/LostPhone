package com.school.portal.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.portal.domain.Attendance;
import com.school.portal.domain.User;
import com.school.portal.enums.AcademicYear;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {

	List<Attendance> findByUserAndAbsentDateAndAcademicYear(User user, LocalDate specificDate,
			AcademicYear academicYear);

	List<Attendance> findAllByAbsentDateBetweenAndUserAndAcademicYear(LocalDate startDate, LocalDate endDate, User user, AcademicYear academicYear);

}
