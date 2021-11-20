package com.pattern.validation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pattern.validation.custom.BetterDate;
import com.pattern.validation.custom.ExtendedEmailValidator;
import com.pattern.validation.service.PatternValidationService;

@Validated
@RestController
public class PatternValidationController {
	
	@Autowired
	public PatternValidationService pvService;
	
	/*
	 * Regular expression for date pattern 2012-12-13T12:12:12
	 */
	public final String strDateRegExp = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])T\\d{2}:\\d{2}:\\d{2}$";
	
	/*
	 * Java Date format for date pattern 2012-12-13T12:12:12
	 */
	public final String strDatePattern = "yyyy-MM-dd'T'hh:mm:ss";
	
	
	/**
	 * 
	 * @param strDate
	 * @return
	 */
	@GetMapping("/validate/date")
	public String validateDate(
			@BetterDate(regExp = strDateRegExp, 
					    pattern = strDatePattern, 
					    message="Please provide a valid date") 
			@RequestParam String strDate) {
		return pvService.success();
	}

	
	/**
	 * 
	 * @param strEmail
	 * @return
	 */
	@GetMapping("/validate/email")
	public String validateEmail(
			@ExtendedEmailValidator
			@RequestParam String strEmail) {
		
		return pvService.success();
	}
}