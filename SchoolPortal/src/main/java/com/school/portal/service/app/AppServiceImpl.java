package com.school.portal.service.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.portal.controller.PortalSettingController;
import com.school.portal.domain.app.ClassMaster;
import com.school.portal.domain.app.Holidays;
import com.school.portal.domain.app.LoginCount;
import com.school.portal.domain.app.SectionMaster;
import com.school.portal.enums.AcademicYear;
import com.school.portal.model.request.ClassSectionCreationModel;
import com.school.portal.repo.ClassMasterRepo;
import com.school.portal.repo.app.AppConfigRepo;
import com.school.portal.repo.app.HolidaysRepo;
import com.school.portal.utils.SchoolPortalUtils;

@Service
public class AppServiceImpl implements AppService {

	@Autowired
	private AppConfigRepo appConfigRepo;

	@Autowired
	private HolidaysRepo holidaysRepo;
	
	@Autowired
	private ClassMasterRepo classMasterRepo;

	@Override
	public LoginCount updateLoginCount(Integer loginCountTobeUpdated, boolean isLoginCountActive) {
		List<LoginCount> appConfig = appConfigRepo.findAll();
		if (appConfig.isEmpty()) {
			LoginCount lc = new LoginCount();
			lc.setCreatedAt(LocalDateTime.now());
			return addOrUpdateLoginCount(lc, loginCountTobeUpdated, isLoginCountActive);
		}
		LoginCount details = appConfig.get(0);
		details.setUpdatedAt(LocalDateTime.now());
		return addOrUpdateLoginCount(details, loginCountTobeUpdated, isLoginCountActive);
	}

	private LoginCount addOrUpdateLoginCount(LoginCount loginCount, Integer loginCountTobeUpdated,
			boolean isLoginCountActive) {
		loginCount.setCountPermited(loginCountTobeUpdated);
		loginCount.setIsActive(isLoginCountActive);
		return appConfigRepo.save(loginCount);
	}

	@Override
	public int getLoginCount() {
		LoginCount appCofing = appConfigRepo.findByIsActive(true);
		if (appCofing != null) {
			return appCofing.getCountPermited();
		}
		return 0;
	}

	@Override
	public List<Holidays> addHolidays(Map<String, String> holiDayMap) {
		List<Holidays> allHolidays = holidaysRepo.findAll();
		if (CollectionUtils.isEmpty(allHolidays)) {
			List<Holidays> holidaysToBeSave = new ArrayList<>();
			holiDayMap.forEach((holidayDate, holidayDescription) -> {
				Holidays holiDay = new Holidays();
				holiDay.setCreatedAt(LocalDateTime.now());
				holiDay.setHolidayDate(LocalDate.parse(holidayDate));
				holiDay.setHolidayDescription(holidayDescription);
				holidaysToBeSave.add(holiDay);
			});
			return holidaysRepo.saveAll(holidaysToBeSave);
		}
		return Collections.emptyList();
	}

	@Override
	public String createClassSection(ClassMaster classMaster, ClassSectionCreationModel classSectionCreationModel) {
		List<SectionMaster> sectionMasterList = new ArrayList<>();
		classMaster.setAcademicYear(AcademicYear.YEAR_2020_2021);
		classMaster.setCreatedById(1l);
		classMaster.setClassUuid(SchoolPortalUtils.getUniqueUuid());
		classSectionCreationModel.getSectionNames().forEach((String sectionName) -> {
			SectionMaster sectionMaster = new SectionMaster();
			sectionMaster.setAcademicYear(AcademicYear.YEAR_2020_2021);
			sectionMaster.setClassMaster(classMaster);
			sectionMaster.setCreatedById(1l);
			sectionMaster.setSectionName(sectionName);
			sectionMaster.setSectionUuid(SchoolPortalUtils.getUniqueUuid());
			sectionMasterList.add(sectionMaster);
        });
		classMaster.setSectionMaster(sectionMasterList);
		ClassMaster createdClass = classMasterRepo.save(classMaster);
		return createdClass.getClassUuid();
	}

}
