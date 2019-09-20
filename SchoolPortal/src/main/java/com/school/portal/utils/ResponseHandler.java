/** Description of class
 * 	
 * 		ResponseHandler class is used for below listed Task
 *  
 *       (1) Handling the response 
 * 
 */
package com.school.portal.utils;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.school.portal.enums.ErrorCode;
import com.school.portal.enums.ResponseCode;


/**
 * @Description : Handle the response
 * @param : httpStatus
 * @param : isError
 * @param : message
 * @param : responseObject
 * @return : map
 * @return : httpStatus
 * 
 * 
 */
public class ResponseHandler {

	private ResponseHandler() {

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

}
