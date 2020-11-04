package com.hms.app.domain.viewdata;

import java.util.Date;

public class AppointmentViewData {
	
	private String id;
	private String appointmentTime;
	private Date date;
	private boolean available;
	private DoctorViewData doctor=new DoctorViewData();
	private CustomerViewData customer=new CustomerViewData();
	private String appointmentNotes;
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
	public DoctorViewData getDoctor() {
		return doctor;
	}
	public void setDoctor(DoctorViewData doctor) {
		this.doctor = doctor;
	}
	public CustomerViewData getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerViewData customer) {
		this.customer = customer;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAppointmentNotes() {
		return appointmentNotes;
	}
	public void setAppointmentNotes(String appointmentNotes) {
		this.appointmentNotes = appointmentNotes;
	}
	
	
	
	
	

}
