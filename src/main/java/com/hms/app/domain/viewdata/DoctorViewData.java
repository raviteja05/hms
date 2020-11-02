package com.hms.app.domain.viewdata;

import java.util.ArrayList;
import java.util.List;

public class DoctorViewData extends UserViewData {
	
	public String designation;
	public String specialization;
	public String qualification;
	public List<AppointmentViewData> appointmentsViewData=new ArrayList<>();
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public List<AppointmentViewData> getAppointmentsViewData() {
		return appointmentsViewData;
	}
	public void setAppointmentsViewData(List<AppointmentViewData> appointmentsViewData) {
		this.appointmentsViewData = appointmentsViewData;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	

}
