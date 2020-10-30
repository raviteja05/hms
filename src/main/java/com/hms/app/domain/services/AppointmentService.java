package com.hms.app.domain.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.hms.app.domain.models.Appointment;
import com.hms.app.domain.models.Customer;
import com.hms.app.domain.models.Doctor;
import com.hms.app.domain.viewdata.AppointmentViewData;

@Service
public class AppointmentService {

	@Resource
	private Environment env;
	
	@Resource
	private UserService userService;

	public List<AppointmentViewData> viewAvailableAppointments(String dateString) {

		List<AppointmentViewData> appointments = getAllAppointmentsForDate(dateString);

		return appointments;
	}

	private List<AppointmentViewData> getAllAppointmentsForDate(String dateString) {
		List<AppointmentViewData> appointments = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		try {
			Date date = sdf.parse(dateString);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			DateTime dateTime = new DateTime(date);
			String startTime = env.getProperty("startTime");
			String endTime = env.getProperty(("endTime"));
			cal.set(dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
					Integer.valueOf(startTime.split(":")[0]), Integer.valueOf(startTime.split(":")[1]));

			int calDay = cal.get(Calendar.DATE);
			while (calDay == cal.get(Calendar.DATE)) {

				DateTime startDateTime = new DateTime(cal.getTime());

				AppointmentViewData appointmentViewData = new AppointmentViewData();
				String startAppointmentTime = formatDate(startDateTime.getHourOfDay()) + ":"
						+ formatDate(startDateTime.getMinuteOfHour());
				cal.add(Calendar.MINUTE, 30);
				DateTime endDateTime = new DateTime(cal.getTime());
				String endAppointmentTime = formatDate(endDateTime.getHourOfDay()) + ":"
						+ formatDate(endDateTime.getMinuteOfHour());
				appointmentViewData.setAppointmentTime(startAppointmentTime + "-" + endAppointmentTime);
				appointmentViewData.setDate(startDateTime.toDate());
				appointmentViewData.setAvailable(true);
				appointments.add(appointmentViewData);
				if (cal.get(Calendar.HOUR_OF_DAY) == Integer.valueOf(endTime.split(":")[0])
						&& cal.get(Calendar.MINUTE) == Integer.valueOf(endTime.split(":")[1]))
					break;

			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appointments;
	}
	
	public void saveAppointment(String custId,String docId,String appointmentDateTime) {
		Optional<Doctor> doctor=userService.findDoctor(docId);
		Optional<Customer> customer=userService.findCustomer(custId);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		try {
			Date date = sdf.parse(appointmentDateTime);
			DateTime dateTime=new DateTime(date);
			
			java.sql.Date dt=new java.sql.Date(dateTime.getMillis());
			java.sql.Time time=new java.sql.Time(dateTime.getMillis());
			Appointment appointment=new Appointment();
			appointment.setDate(dt);
			appointment.setTime(time);
			doctor.get().getAppointments().add(appointment);
			customer.get().getAppointments().add(appointment);
			
			userService.saveCustomer(customer.get());
			userService.saveDoctor(doctor.get());
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private String formatDate(int hourOrMinute) {
		return String.format("%02d", hourOrMinute);
	}

}
