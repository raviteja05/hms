package com.hms.app.domain.populators;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.hms.app.domain.models.Appointment;
import com.hms.app.domain.models.Doctor;
import com.hms.app.domain.models.User;
import com.hms.app.domain.viewdata.AppointmentViewData;
import com.hms.app.domain.viewdata.DoctorViewData;
import com.hms.app.populator.Populator;
@Component
public class DoctorViewDataPopulator implements Populator<Doctor, DoctorViewData>{

	@Override
	public void populate(Doctor doctor, DoctorViewData target) {
		target.setEmail(doctor.getEmail());
		target.setFirstName(doctor.getFirstName());
		target.setLastName(doctor.getLastName());
		target.setDesignation(doctor.getDesignation());
		List<AppointmentViewData> appointmentViewDatas=new ArrayList<>();
		
		doctor.getAppointments().forEach(appointment->populateAppointment(appointment,appointmentViewDatas));
		target.setAppointmentsViewData(appointmentViewDatas);
		
	}

	private void populateAppointment(Appointment appointment, List<AppointmentViewData> appointmentViewDatas) {
		AppointmentViewData appointmentViewData=new AppointmentViewData();
		DateTime dateTime=new DateTime(appointment.getTime());
		
		Calendar cal=Calendar.getInstance();
		cal.set(dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(), dateTime.getHourOfDay(), dateTime.getMinuteOfHour());
		
		String startTime=formatDate(dateTime.getHourOfDay())+":"+formatDate(dateTime.getMinuteOfDay());
		
		cal.add(Calendar.MINUTE, 15);
		DateTime endDateTime = new DateTime(cal.getTime());
		String endTime=formatDate(endDateTime.getHourOfDay())+":"+formatDate(endDateTime.getMinuteOfDay());
		appointmentViewData.setAppointmentTime(startTime+":"+endTime);
		appointmentViewData.setDate(dateTime.toDate());
		appointmentViewDatas.add(appointmentViewData);
		
		
	}
	private String formatDate(int hourOrMinute) {
		return String.format("%02d", hourOrMinute);
	}

}
