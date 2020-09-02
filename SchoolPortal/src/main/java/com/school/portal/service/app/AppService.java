package com.school.portal.service.app;

import java.util.List;
import java.util.Map;

import com.school.portal.domain.app.Holidays;
import com.school.portal.domain.app.LoginCount;

public interface AppService {

	LoginCount updateLoginCount(Integer loginCount, boolean isLoginCountActive);

	int getLoginCount();

	List<Holidays> addHolidays(Map<String, String> holiDayMap);

}
