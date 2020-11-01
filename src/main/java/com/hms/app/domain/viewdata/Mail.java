package com.hms.app.domain.viewdata;

import java.util.Map;

public class Mail<T> {

	private String mailFrom;
	 
	private String mailTo;
 
	private String mailSubject;
 
	private String mailContent;
 
	private String templateName;
 
	private String contentType;
	
	private Map<String,T> mailProps;
 
	
 
	public String getContentType() {
		return contentType;
	}
 
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
 
	public String getTemplateName() {
		return templateName;
	}
 
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

 
	public String getMailFrom() {
		return mailFrom;
	}
 
	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}
 
	public String getMailSubject() {
		return mailSubject;
	}
 
	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}
 
	public String getMailTo() {
		return mailTo;
	}
 
	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}
 
	
	public String getMailContent() {
		return mailContent;
	}
 
	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}

	public Map<String, T> getMailProps() {
		return mailProps;
	}

	public void setMailProps(Map<String, T> mailProps) {
		this.mailProps = mailProps;
	}
	
}
