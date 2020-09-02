package com.school.portal.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.school.portal.domain.ClassMaster;
import com.school.portal.domain.SectionMaster;
import com.school.portal.domain.User;
import com.school.portal.dto.BaseResponseModel;
import com.school.portal.dto.EnabledClassDto;
import com.school.portal.enums.ErrorCode;
import com.school.portal.enums.ResponseCode;

public class ResponseBuilder {

	private ResponseBuilder() {
		//
	}

	public static Map<String, Object> buildClassResponse(ClassMaster classDetails) {
		Map<String, Object> map = new HashMap<>();
		map.put("className", classDetails.getClassName());
		map.put("classId", classDetails.getId());
		map.put("createdAt", classDetails.getCreatedAt());
		map.put("isActive", classDetails.getIsActive());
		List<SectionMaster> sectionList = classDetails.getSectionMaster();
		List<String> listOfSectionName = new ArrayList<>();
		for (SectionMaster sectionMaster : sectionList) {
			if (sectionMaster.getIsActive()) {
				listOfSectionName.add(sectionMaster.getSectionName());
			}
		}
		map.put("sectionName", listOfSectionName);
		return map;
	}

	public static Map<String, Object> buildClassResponse(List<ClassMaster> classDetailsList) {
		Map<String, Object> map = new HashMap<>();
		for (ClassMaster classMaster : classDetailsList) {
			List<SectionMaster> sectionList = classMaster.getSectionMaster();
			List<String> listOfSectionName = new ArrayList<>();
			for (SectionMaster sectionMaster : sectionList) {
				if (sectionMaster.getIsActive()) {
					listOfSectionName.add(sectionMaster.getSectionName());
				}
			}
			map.put(classMaster.getClassName(), listOfSectionName);
		}
		return map;
	}

	public static Map<String, Object> buildEnableClassAndSectionResponse(List<ClassMaster> classDetailsList) {
		Map<String, Object> map = new HashMap<>();
		for (ClassMaster classMaster : classDetailsList) {
			if (Boolean.TRUE.equals(classMaster.getIsActive())) {
				EnabledClassDto classDto = new EnabledClassDto();
				classDto.setActive(classMaster.getIsActive());
				classDto.setClassName(classMaster.getClassName());
				classDto.setCreatedAt(classMaster.getCreatedAt());
				classDto.setClassId(classMaster.getId());
				List<SectionMaster> sectionMaster = classMaster.getSectionMaster();
				for (SectionMaster section : sectionMaster) {
					if (Boolean.TRUE.equals(section.getIsActive())) {
						classDto.setSectionMaster(sectionMaster);
					}
				}
				map.put(classMaster.getClassName(), classDto);
			}
		}
		return map;
	}

	public static Map<String, Object> buildLoginResponse(String jwtToken, User user) {
		Map<String, Object> map = new HashMap<>();
		map.put("token", jwtToken);
		map.put("userName", user.getUsername());
		map.put("userType", user.getUserType());
		return map;
	}
	
	/**
	 * 
	 * @param httpStatus
	 * @param isError
	 * @param message
	 * @param errorCode
	 * @param responseObject
	 * @return
	 */
	public static ResponseEntity<Object> response(HttpStatus httpStatus, Boolean isError, String message,
			ErrorCode errorCode, ResponseCode responseCode) {

		Map<String, Object> map = new TreeMap<>();
		map.put("timestamp", new Date().getTime());
		map.put("httpStatus", httpStatus.value());
		map.put("isError", isError);

		if (isError) {
			Error error = new Error(message, errorCode, message);
			map.put("error", error);
			map.put("errorStatus", errorCode.value());
		}
		map.put("message", message);
		map.put("responseCode", responseCode.value());
		return new ResponseEntity<>(map, httpStatus);

	}

	/**
	 * 
	 * @param httpStatus
	 * @param isError
	 * @param message
	 * @param errorCode
	 * @param responseObject
	 * @param responseCode
	 * @return
	 */
	public static ResponseEntity<Object> response(HttpStatus httpStatus, Boolean isError, String message,
			ErrorCode errorCode, ResponseCode responseCode, Object responseObject) {
		Map<String, Object> map = new TreeMap<>();
		map.put("timestamp", new Date().getTime());
		map.put("status", httpStatus.value());
		map.put("isError", isError);
		if (isError) {
			Error error = new Error(message, errorCode, message);
			map.put("error", error);
			map.put("errorStatus", errorCode.value());
		}
		map.put("message", message);
		map.put("responseCode", responseCode.value());
		map.put("responseObject", responseObject);
		return new ResponseEntity<>(map, httpStatus);

	}
	
    public static <S, D> ResponseEntity<Object> getApiBaseResponseData(final Mapper beanMapper, final List<S> dataDtos, final Class<D> modelClass) {
        if (CollectionUtils.isNotEmpty(dataDtos)) {
            final List<D> dataModels = DozerMapperUtil.mapCollection(beanMapper, dataDtos, modelClass);
            final BaseResponseModel<D> baseResponseModel = mapToBaseResponseModel(dataModels, Long.MAX_VALUE, Long.valueOf(dataModels.size()));
            return ResponseEntity.ok(baseResponseModel);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
    public static <T> BaseResponseModel<T> mapToBaseResponseModel(final List<T> object, final Long limit, final Long count) {
        final BaseResponseModel<T> baseResponseModel = new BaseResponseModel<>();
        baseResponseModel.setData(object);
        baseResponseModel.setCount(count);
        if (limit != null) {
            long pages = count / limit;
            if (count % limit > 0) {
                pages += 1;
            }
            baseResponseModel.setPages(pages == 0 ? 1 : pages);
        }
        return baseResponseModel;
    }
}
