package com.hms.app.utils;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RandomPasswordGeneratorUtilTest {
	
	@InjectMocks
	private RandomPasswordGeneratorUtil randomPasswordGeneratorUtil=new RandomPasswordGeneratorUtil();
	
	@Test
	public void testGeneratePasswordLength() {
		String password=randomPasswordGeneratorUtil.generateRandomPassword(10);
		
		assertTrue(password.length()==10);
		
		
	}
	@Test
	public void testGeneratePasswordPattern() {
		String password=randomPasswordGeneratorUtil.generateRandomPassword(10);
		
		
		assertTrue(password.matches("[a-zA-Z0-9]{10}"));
		
	}

}
