package com.hms.app.domain.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.hms.app.domain.models.Appointment;
import com.hms.app.domain.models.Customer;
import com.hms.app.domain.models.Doctor;
import com.hms.app.domain.models.Prescription;
import com.hms.app.domain.populators.AppointmentViewDataPopulator;
import com.hms.app.domain.populators.CustomerViewDataPopulator;
import com.hms.app.domain.repository.AppointmentRepository;
import com.hms.app.domain.viewdata.AppointmentViewData;
import com.hms.app.domain.viewdata.BookingDetailsViewData;
import com.hms.app.domain.viewdata.CustomerViewData;
import com.hms.app.domain.viewdata.Mail;

@Service
public class AppointmentService {

	@Resource
	private Environment env;

	@Resource
	private UserService userService;

	@Resource
	private AppointmentRepository appointmentRepository;

	@Resource
	private AppointmentViewDataPopulator appointmentViewDataPopulator;
	
	@Resource
	private CustomerViewDataPopulator customerViewDataPopulator;
	
	@Resource
	private PrescriptionService prescriptionService;
	
	@Resource
	private EmailService<BookingDetailsViewData> emailService;

	public List<AppointmentViewData> viewAvailableAppointments(String dateString, String docId) {

		List<AppointmentViewData> appointments = getAllAppointmentsForDate(dateString, docId);

		return appointments;
	}

	public List<AppointmentViewData> getAppointmentsForDoctor(String doctorID) {
		Optional<Doctor> doctor = userService.findDoctor(doctorID);
		List<AppointmentViewData> appointmentViewDatas = new ArrayList<AppointmentViewData>();

		doctor.get().getAppointments().stream().filter(appointment -> checkIfAppointmentDateisPassed(appointment))
				.forEach(appointment -> {
					AppointmentViewData appointmentViewData = new AppointmentViewData();
					appointmentViewDataPopulator.populate(appointment, appointmentViewData);
					appointmentViewDatas.add(appointmentViewData);

				});

		return appointmentViewDatas;

	}
	
	public void savePrescription(String customerId,String doctorId,Prescription prescription) {
		Optional<Customer> customer=userService.findCustomer(customerId);
		Optional<Doctor> doctor=userService.findDoctor(doctorId);
		DateTime dateTime=new DateTime(new Date());
		prescription.setCustomer(customer.get());
		prescription.setDoctor(doctor.get());
		prescription.setDate(new java.sql.Date(dateTime.getMillis()));
		
		
		prescriptionService.savePrescription(prescription);
		
	}
	
	
	
	public CustomerViewData getCustomerDetailsFromAppointment(String appointmentId) {
		Optional<Appointment> appointment=appointmentRepository.findById(appointmentId);
		CustomerViewData customerViewData=new CustomerViewData();
		customerViewDataPopulator.populate(appointment.get().getCustomer(), customerViewData);
		return customerViewData;
		
		
	}
	
	public void deleteAppointment(String appId) {
		appointmentRepository.deleteById(appId);
		 
	}

	public List<AppointmentViewData> getAppointmentsForCustomer(String customerId) {
		Optional<Customer> customer = userService.findCustomer(customerId);
		List<AppointmentViewData> appointmentViewDatas = new ArrayList<AppointmentViewData>();

		customer.get().getAppointments().stream().filter(appointment -> checkIfAppointmentDateisPassed(appointment))
				.forEach(appointment -> {
					AppointmentViewData appointmentViewData = new AppointmentViewData();
					appointmentViewDataPopulator.populate(appointment, appointmentViewData);
					appointmentViewDatas.add(appointmentViewData);

				});

		return appointmentViewDatas;

	}
	public List<AppointmentViewData> getPastAppointmentsForCustomer(String customerId) {
		Optional<Customer> customer = userService.findCustomer(customerId);
		List<AppointmentViewData> appointmentViewDatas = new ArrayList<AppointmentViewData>();

		customer.get().getAppointments().stream().filter(appointment -> !checkIfAppointmentDateisPassed(appointment))
				.forEach(appointment -> {
					AppointmentViewData appointmentViewData = new AppointmentViewData();
					appointmentViewDataPopulator.populate(appointment, appointmentViewData);
					appointmentViewDatas.add(appointmentViewData);

				});

		return appointmentViewDatas;

	}
	
	private boolean checkIfAppointmentDateisPassed(Appointment appointment) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=null;
		try {
			date=sdf.parse(appointment.getDate().toString()+" "+appointment.getTime().toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return !(new DateTime(date).isBeforeNow());
	}

	private List<AppointmentViewData> getAllAppointmentsForDate(String dateString, String id) {
		List<AppointmentViewData> appointments = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Optional<Doctor> doctor = userService.findDoctor(id);

		List<Appointment> appointment = doctor.get().getAppointments();

		List<String> bookedAppointmentList = appointment.stream()
				.map(app -> sdf.format(app.getDate()) + " " + app.getTime().toString()).collect(Collectors.toList());

		try {
			Date date = sdf.parse(dateString);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			DateTime dateTime = new DateTime(date);
			String startTime = env.getProperty("startTime");
			String endTime = env.getProperty(("endTime"));
			cal.set(dateTime.getYear(), dateTime.getMonthOfYear() - 1, dateTime.getDayOfMonth(),
					Integer.valueOf(startTime.split(":")[0]), Integer.valueOf(startTime.split(":")[1]));

			int calDay = cal.get(Calendar.DATE);
			while (calDay == cal.get(Calendar.DATE)) {

				DateTime startDateTime = new DateTime(cal.getTime());

				AppointmentViewData appointmentViewData = new AppointmentViewData();
				String startAppointmentTime = formatDate(startDateTime.getHourOfDay()) + ":"
						+ formatDate(startDateTime.getMinuteOfHour());
				cal.add(Calendar.MINUTE, Integer.valueOf(env.getProperty("appointment.duration.minutes")));
				DateTime endDateTime = new DateTime(cal.getTime());
				String endAppointmentTime = formatDate(endDateTime.getHourOfDay()) + ":"
						+ formatDate(endDateTime.getMinuteOfHour());
				appointmentViewData.setAppointmentTime(startAppointmentTime + "-" + endAppointmentTime);
				appointmentViewData.setDate(startDateTime.toDate());
				SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				String formattedDate = sdf1.format(appointmentViewData.getDate());
				appointmentViewData.setAvailable(true);
				if (bookedAppointmentList.contains(formattedDate) || startDateTime.isBeforeNow()) {
					appointmentViewData.setAvailable(false);
				}
				if (!startDateTime.isBeforeNow())
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

	public BookingDetailsViewData saveAppointment(String custId, String docId, String appointmentDateTime) {
		

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		BookingDetailsViewData bookingDetails = null;
		Optional<Doctor> doctor = userService.findDoctor(docId);
		try {
			Date date = sdf.parse(appointmentDateTime);
			DateTime dateTime = new DateTime(date);

			java.sql.Date dt = new java.sql.Date(dateTime.getMillis());
			java.sql.Time time = new java.sql.Time(dateTime.getMillis());
			if(checkIfAppointmentIsAvailable(dt,time,doctor)) {
			
			Optional<Customer> customer = userService.findCustomer(custId);
			bookingDetails = new BookingDetailsViewData();
			Appointment appointment = new Appointment();
			appointment.setDate(dt);
			appointment.setTime(time);
			appointment.setCustomer(customer.get());
			appointment.setDoctor(doctor.get());
			appointmentRepository.save(appointment);

			bookingDetails.setDoctorName(doctor.get().getFirstName() + " " + doctor.get().getLastName());
			bookingDetails.setAppointmentDateTime(appointmentDateTime);

			Mail<BookingDetailsViewData> mail = new Mail();
			Map<String, BookingDetailsViewData> propsMap = new HashMap<>();
			propsMap.put("bookingDetails", bookingDetails);
			mail.setMailTo(customer.get().getEmail());
			mail.setMailProps(propsMap);
			mail.setTemplateName("email");
			mail.setMailSubject("AppCal: Appointment Confirmation");
			mail.setMailContent(String.format(env.getProperty("mail.booking.confirmationtext"),
					customer.get().getFirstName() + " " + customer.get().getLastName(), bookingDetails.getDoctorName(),
					bookingDetails.getAppointmentDateTime()));
			emailService.sendMail(mail);
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookingDetails;

	}

	private boolean checkIfAppointmentIsAvailable(java.sql.Date dt, Time time, Optional<Doctor> doctor) {
		Optional<Appointment> appointment=appointmentRepository.findByDateAndTimeAndDoctor(dt, time, doctor.get());
		return !appointment.isPresent();
	}

	private String formatDate(int hourOrMinute) {
		return String.format("%02d", hourOrMinute);
	}

}
