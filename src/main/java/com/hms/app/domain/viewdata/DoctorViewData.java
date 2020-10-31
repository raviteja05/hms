package com.hms.app.domain.viewdata;

import java.util.ArrayList;
import java.util.List;

public class DoctorViewData extends UserViewData {
	
	public String designation;
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
	

}
