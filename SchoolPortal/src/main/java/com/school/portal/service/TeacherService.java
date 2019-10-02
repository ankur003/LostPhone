/**
 * 
 */
package com.school.portal.service;

import com.school.portal.domain.User;
import com.school.portal.dto.CreateTeacherForm;

/**
 * @author shakher
 *
 */
public interface TeacherService {

	boolean checkAlreadyExist(CreateTeacherForm createTeacherForm);

	User createTeacher(CreateTeacherForm createTeacherForm);

}
