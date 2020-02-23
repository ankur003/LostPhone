package com.school.portal.repo.app;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.portal.domain.app.Holidays;

public interface HolidaysRepo extends JpaRepository<Holidays, Long> {

	Holidays findByHolidayDate(Date holidayDate);

}