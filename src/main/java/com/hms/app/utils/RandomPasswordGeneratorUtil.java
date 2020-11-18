package com.hms.app.utils;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Component;

@Component
public class RandomPasswordGeneratorUtil {
	
	public String generateRandomPassword(int length) {
	    RandomStringGenerator pwdGenerator = new RandomStringGenerator.Builder().withinRange('0','z')
	        .build();
	    return pwdGenerator.generate(length);
	}

}
