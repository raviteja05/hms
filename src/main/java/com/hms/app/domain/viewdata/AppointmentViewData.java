package com.hms.app.domain.viewdata;

import java.util.Date;

public class AppointmentViewData {
	
	
	private String appointmentTime;
	private Date date=new Date();
	private boolean available;
	public String getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
