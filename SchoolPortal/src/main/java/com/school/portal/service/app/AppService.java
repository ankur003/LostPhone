package com.school.portal.service.app;

import com.school.portal.domain.app.LoginCount;

public interface AppService {

	LoginCount updateLoginCount(Integer loginCount, boolean isLoginCountActive);

	int getLoginCount();

}
