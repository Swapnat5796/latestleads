package com.company.lead.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	public Map<String, String> codeMap() {
		Map<String, String> map = new HashMap<>();
		map.put("E10010", "Lead Already Exists in the database with the lead id");
		map.put("E10011", "No Lead found with the Mobile Number ");
		return map;
	}

	@ExceptionHandler(value = { CustomException.class })
	public ResponseEntity<Object> handleCustomExceptionHandler(CustomException customException) {
		Map<String, String> map = codeMap();
		LeadException leadException = new LeadException(map.get(customException.getMessage()),
				customException.getCause(), HttpStatus.NOT_FOUND, customException.getMessage());

		return new ResponseEntity<>(leadException, HttpStatus.NOT_FOUND);

	}
}
