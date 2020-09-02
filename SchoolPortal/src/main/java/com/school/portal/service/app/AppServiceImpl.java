package com.school.portal.service.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.portal.domain.app.Holidays;
import com.school.portal.domain.app.LoginCount;
import com.school.portal.repo.app.AppConfigRepo;
import com.school.portal.repo.app.HolidaysRepo;


@Service
public class AppServiceImpl implements AppService {

	@Autowired
	private AppConfigRepo appConfigRepo;

	@Autowired
	private HolidaysRepo holidaysRepo;

	private SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

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
		loginCount.setLoginCount(loginCountTobeUpdated);
		loginCount.setLoginCountActive(isLoginCountActive);
		return appConfigRepo.save(loginCount);
	}

	@Override
	public int getLoginCount() {
		LoginCount appCofing = appConfigRepo.findByIsLoginCountActive(true);
		if (appCofing != null) {
			return appCofing.getLoginCount();
		}
		return 0;
	}

	@Override
	public List<Holidays> addHolidays(Map<String, String> holiDayMap) {
		List<Holidays> allHolidays = holidaysRepo.findAll();
		if (CollectionUtils.isEmpty(allHolidays)) {
			List<Holidays> holidaysToBeSave = new ArrayList<>();
			holiDayMap.forEach((holidayDate, holidayDescription) -> {
				try {
					Holidays holiDay = new Holidays();
					holiDay.setCreatedAt(LocalDateTime.now());
					holiDay.setHolidayDate(formatter.parse(holidayDate));
					holiDay.setHolidayDescription(holidayDescription);
					holidaysToBeSave.add(holiDay);
				} catch (ParseException e) {
					// to be handled
				}
			});
			return holidaysRepo.saveAll(holidaysToBeSave);
		}
		return Collections.emptyList();
	}

}
