package com.hms.app.domain.services;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import com.hms.app.domain.viewdata.Mail;
@Service
public class EmailService<T> {
	@Resource
	private JavaMailSender mailSender;
//	@Resource
//	private SpringTemplateEngine templateEngine;

	public void sendMail(Mail mail) {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setTo(mail.getMailTo());
			helper.setSubject(mail.getMailSubject());
			

	    
	        String html = mail.getMailContent();
			helper.setText(html, true);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mailSender.send(message);
	}

}
