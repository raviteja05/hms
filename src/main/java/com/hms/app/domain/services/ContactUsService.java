package com.hms.app.domain.services;

import javax.annotation.Resource;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.hms.app.domain.viewdata.ContactUsViewData;
import com.hms.app.domain.viewdata.Mail;

@Service
public class ContactUsService {
	@Resource
	private EmailService<ContactUsViewData> emailService;
	
	@Resource
	private Environment env;
	
	public void sendFeedback(ContactUsViewData contactUsViewData) {
		
		Mail mail=new Mail();
		mail.setMailFrom(contactUsViewData.getEmail());
		mail.setMailTo("appcalgroup@gmail.com");
		mail.setMailSubject("[Feedback] from "+contactUsViewData.getName()+": "+contactUsViewData.getSubject());
		mail.setMailContent("Email:"+contactUsViewData.getEmail()+"<br/><br/>"+ contactUsViewData.getMessage());
		
		emailService.sendMail(mail);
	}
	

}
