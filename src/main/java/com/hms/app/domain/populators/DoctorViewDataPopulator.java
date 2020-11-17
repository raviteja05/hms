package com.hms.app.domain.populators;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.hms.app.domain.models.Appointment;
import com.hms.app.domain.models.Doctor;
import com.hms.app.domain.viewdata.AppointmentViewData;
import com.hms.app.domain.viewdata.DoctorViewData;
import com.hms.app.populator.Populator;
@Component
public class DoctorViewDataPopulator implements Populator<Doctor, DoctorViewData>{
	
	@Resource
	private Environment env;

	@Override
	public void populate(Doctor doctor, DoctorViewData target) {
		target.setEmail(doctor.getEmail());
		target.setFirstName(doctor.getFirstName());
		target.setLastName(doctor.getLastName());
		target.setAddress(doctor.getAddress());
		target.setPhoneNo(doctor.getPhoneNo());
		target.setDesignation(doctor.getDesignation());
		target.setQualification(doctor.getQualification());
		target.setSpecialization(doctor.getSpecialization());
		
		
	}

	private void populateAppointment(Appointment appointment, List<AppointmentViewData> appointmentViewDatas) {
		AppointmentViewData appointmentViewData=new AppointmentViewData();
		DateTime dateTime=new DateTime(appointment.getTime());
		
		Calendar cal=Calendar.getInstance();
		cal.set(dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(), dateTime.getHourOfDay(), dateTime.getMinuteOfHour());
		
		String startTime=formatDate(dateTime.getHourOfDay())+":"+formatDate(dateTime.getMinuteOfDay());
		
		cal.add(Calendar.MINUTE, Integer.valueOf(env.getProperty("appointment.duration.minutes")));
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
