package com.school.portal.controller;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbstractController {
	
    @Autowired
    protected Mapper beanMapper;

}
