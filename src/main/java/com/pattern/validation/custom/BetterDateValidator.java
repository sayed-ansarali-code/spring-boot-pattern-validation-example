package com.pattern.validation.custom;

import java.text.SimpleDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BetterDateValidator implements ConstraintValidator<BetterDate, String> {

	private String pattern;
	
	private String regExp;
	
	private ThreadLocal<SimpleDateFormat> format;

	@Override
	public void initialize(BetterDate betterDate) {
		this.pattern = betterDate.pattern();
		this.regExp = betterDate.regExp();
		format = new ThreadLocal<SimpleDateFormat>() {
		    @Override
		    protected SimpleDateFormat initialValue() {
		        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		        sdf.setLenient(false);
		        return sdf;
		    }
		};
	}

	@Override
	public boolean isValid(String strDate, ConstraintValidatorContext cxt) {
		
		if (strDate == null || !strDate.matches(regExp)) {
			return false;
		}

		try {
			format.get().parse(strDate);
			return true;
		} catch (Exception e) {
//			e.printStackTrace();
			return false;
		}
	}

}