package com.school.portal.service.app;

import java.util.HashMap;
import java.util.List;

import com.school.portal.domain.app.Holidays;
import com.school.portal.domain.app.LoginCount;

public interface AppService {

	LoginCount updateLoginCount(Integer loginCount, boolean isLoginCountActive);

	int getLoginCount();

	List<Holidays> addHolidays(HashMap<String, String> holiDayMap);

}
