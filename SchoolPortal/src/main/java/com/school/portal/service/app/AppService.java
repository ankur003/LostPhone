package com.school.portal.service.app;

import com.school.portal.domain.app.LoginCountConfig;

public interface AppService {

	LoginCountConfig updateLoginCount(Integer loginCount, boolean isLoginCountActive);

}
