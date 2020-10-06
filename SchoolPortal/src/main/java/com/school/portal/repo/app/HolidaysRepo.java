package com.school.portal.repo.app;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.portal.domain.app.Holidays;
import com.school.portal.enums.AcademicYear;

public interface HolidaysRepo extends JpaRepository<Holidays, Long> {

	Holidays findByHolidayDateAndAcademicYear(LocalDate holidayDate, AcademicYear academicYear);

}