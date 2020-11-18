package com.hms.app.utils;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Component;

@Component
public class RandomPasswordGeneratorUtil {
	
	public String generateRandomPassword(int length) {
		char[][] pairs= {{'0','9'},{'a','z'},{'A','Z'}};
	    RandomStringGenerator pwdGenerator = new RandomStringGenerator.Builder().withinRange(pairs)
	        .build();
	    return pwdGenerator.generate(length);
	}

}
