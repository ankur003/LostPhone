package com.school.portal.service.app;

import java.util.List;
import java.util.Map;

import com.school.portal.domain.app.ClassMaster;
import com.school.portal.domain.app.Holidays;
import com.school.portal.domain.app.LoginCount;
import com.school.portal.model.request.ClassSectionCreationModel;

public interface AppService {

	LoginCount updateLoginCount(Integer loginCount, boolean isLoginCountActive);

	int getLoginCount();

	List<Holidays> addHolidays(Map<String, String> holiDayMap);

	String createClassSection(ClassMaster classMaster, ClassSectionCreationModel classSectionCreationModel);

}
