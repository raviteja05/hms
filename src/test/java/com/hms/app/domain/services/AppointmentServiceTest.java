package com.hms.app.domain.services;

import static org.junit.Assert.assertTrue;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import com.hms.app.domain.models.Appointment;
import com.hms.app.domain.models.Customer;
import com.hms.app.domain.models.Doctor;
import com.hms.app.domain.populators.AppointmentViewDataPopulator;
import com.hms.app.domain.populators.CustomerViewDataPopulator;
import com.hms.app.domain.populators.DoctorViewDataPopulator;
import com.hms.app.domain.repository.AppointmentRepository;
import com.hms.app.domain.viewdata.AppointmentViewData;
import com.hms.app.domain.viewdata.CustomerViewData;
import com.hms.app.domain.viewdata.DoctorViewData;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AppointmentServiceTest {
	@InjectMocks
	private AppointmentService appointmentService = new AppointmentService();
	@Mock
	private Environment env;

	@Mock
	private UserService userService;

	@Mock
	private AppointmentRepository appointmentRepository;

	@Mock
	private AppointmentViewDataPopulator appointmentViewDataPopulator;
	
	@Mock
	private DoctorViewDataPopulator doctorViewDataPopulator;
	

	@Mock
	private CustomerViewDataPopulator customerViewDataPopulator;

	@Mock
	private PrescriptionService prescriptionService;

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testTimeSlotsFifteenMinutes() {

		Mockito.when(env.getProperty("startTime")).thenReturn("08:00");
		Mockito.when(env.getProperty("endTime")).thenReturn("18:00");
		Mockito.when(env.getProperty("appointment.duration.minutes")).thenReturn("15");
		Doctor doctor = new Doctor();
		Optional<Doctor> doc = Optional.of(doctor);
		Mockito.when(userService.findDoctor(Mockito.anyString())).thenReturn(doc);
		List<AppointmentViewData> appointments = appointmentService.viewAvailableAppointments("25-01-2021",
				"ravi@appcal.com");

		List<String> slots = appointments.stream().map(appointment -> appointment.getAppointmentTime())
				.collect(Collectors.toList());

		assertTrue(slots.get(0).contentEquals("08:00-08:15"));
		assertTrue(slots.get(slots.size() - 1).contentEquals("17:45-18:00"));

	}

	@Test
	public void testTimeSlotsThirtyMinutes() {

		Mockito.when(env.getProperty("startTime")).thenReturn("08:00");
		Mockito.when(env.getProperty("endTime")).thenReturn("18:00");
		Mockito.when(env.getProperty("appointment.duration.minutes")).thenReturn("30");
		Doctor doctor = new Doctor();
		Optional<Doctor> doc = Optional.of(doctor);
		Mockito.when(userService.findDoctor(Mockito.anyString())).thenReturn(doc);
		List<AppointmentViewData> appointments = appointmentService.viewAvailableAppointments("25-01-2021",
				"ravi@appcal.com");

		List<String> slots = appointments.stream().map(appointment -> appointment.getAppointmentTime())
				.collect(Collectors.toList());

		assertTrue(slots.get(0).contentEquals("08:00-08:30"));
		assertTrue(slots.get(slots.size() - 1).contentEquals("17:30-18:00"));

	}

	@Test
	public void testTimeSlotsDateException() {

		Mockito.when(env.getProperty("startTime")).thenReturn("08:00");
		Mockito.when(env.getProperty("endTime")).thenReturn("18:00");
		Mockito.when(env.getProperty("appointment.duration.minutes")).thenReturn("15");
		Doctor doctor = new Doctor();
		Optional<Doctor> doc = Optional.of(doctor);
		Mockito.when(userService.findDoctor(Mockito.anyString())).thenReturn(doc);

		appointmentService.viewAvailableAppointments("", "ravi@appcal.com");

		exception.expect(ParseException.class);

	}
	
	@Test
	public void testBookedAppointmentAvailability() {

		Mockito.when(env.getProperty("startTime")).thenReturn("08:00");
		Mockito.when(env.getProperty("endTime")).thenReturn("18:00");
		Mockito.when(env.getProperty("appointment.duration.minutes")).thenReturn("15");
		Doctor doctor = new Doctor();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy HH:mm");
		DateTime dateTime;
		try {
			dateTime = new DateTime(sdf.parse("25-01-2021 10:30"));
			
			Appointment appointment=new Appointment();
			appointment.setDate(new java.sql.Date(dateTime.getMillis()));
			appointment.setTime(new Time(dateTime.getMillis()));
			
			Optional<Doctor> doc = Optional.of(doctor);
			doc.get().getAppointments().add(appointment);
			Mockito.when(userService.findDoctor("ravi@appcal.com")).thenReturn(doc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		List<AppointmentViewData> appointments = appointmentService.viewAvailableAppointments("25-01-2021", "ravi@appcal.com");
		
		
		 Map<String,Boolean> slotsMap=appointments.stream().collect(Collectors.toMap(AppointmentViewData::getAppointmentTime,AppointmentViewData::isAvailable));
		assertTrue(!slotsMap.get("10:30-10:45"));
	}
	
	@Test
	public void testAppointmentSlotsForDatesPassed() {

		Mockito.when(env.getProperty("startTime")).thenReturn("08:00");
		Mockito.when(env.getProperty("endTime")).thenReturn("18:00");
		Mockito.when(env.getProperty("appointment.duration.minutes")).thenReturn("15");
		Doctor doctor = new Doctor();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy HH:mm");
		DateTime dateTime;
		try {
			dateTime = new DateTime(sdf.parse("25-11-2019 10:30"));
			
			Appointment appointment=new Appointment();
			appointment.setDate(new java.sql.Date(dateTime.getMillis()));
			appointment.setTime(new Time(dateTime.getMillis()));
			
			Optional<Doctor> doc = Optional.of(doctor);
			doc.get().getAppointments().add(appointment);
			Mockito.when(userService.findDoctor("ravi@appcal.com")).thenReturn(doc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		List<AppointmentViewData> appointments = appointmentService.viewAvailableAppointments("25-11-2019", "ravi@appcal.com");		 
		assertTrue(appointments.isEmpty());
	}
	
	@Test
	public void testStartAndEndAppointmentTimeSlots() {

		Mockito.when(env.getProperty("startTime")).thenReturn("09:00");
		Mockito.when(env.getProperty("endTime")).thenReturn("13:00");
		Mockito.when(env.getProperty("appointment.duration.minutes")).thenReturn("15");
		Doctor doctor = new Doctor();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy HH:mm");
		DateTime dateTime;
		try {
			dateTime = new DateTime(sdf.parse("25-01-2021 10:30"));
			
			Appointment appointment=new Appointment();
			appointment.setDate(new java.sql.Date(dateTime.getMillis()));
			appointment.setTime(new Time(dateTime.getMillis()));
			
			Optional<Doctor> doc = Optional.of(doctor);
			doc.get().getAppointments().add(appointment);
			Mockito.when(userService.findDoctor("ravi@appcal.com")).thenReturn(doc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		List<AppointmentViewData> appointments = appointmentService.viewAvailableAppointments("25-01-2021", "ravi@appcal.com");
		List<String> slots = appointments.stream().map(appointment -> appointment.getAppointmentTime())
				.collect(Collectors.toList());
		assertTrue(slots.get(0).contentEquals("09:00-09:15"));
		assertTrue(slots.get(slots.size() - 1).contentEquals("12:45-13:00"));
	}
	
	@Test
	public void testGetPastAppointmentsForCustomer() {

		Mockito.when(env.getProperty("startTime")).thenReturn("09:00");
		Mockito.when(env.getProperty("endTime")).thenReturn("13:00");
		Mockito.when(env.getProperty("appointment.duration.minutes")).thenReturn("15");
		Customer cust = new Customer();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		DateTime dateTime;
		DateTime dateTime1;
		try {
			dateTime = new DateTime(sdf.parse("2021-01-25 10:30"));
			dateTime1 = new DateTime(sdf.parse("2019-11-25 10:30"));
			
			Appointment appointment=new Appointment();
			appointment.setDate(new java.sql.Date(dateTime.getMillis()));
			appointment.setTime(new Time(dateTime.getMillis()));
			appointment.setId(0);
			
			Appointment appointment1=new Appointment();
			appointment1.setDate(new java.sql.Date(dateTime1.getMillis()));
			appointment1.setTime(new Time(dateTime1.getMillis()));
			appointment.setId(1);
			
			Optional<Customer> customer = Optional.of(cust);
			customer.get().getAppointments().add(appointment);
			customer.get().getAppointments().add(appointment1);
			
			Mockito.when(userService.findCustomer("sam@gmail.com")).thenReturn(customer);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		List<AppointmentViewData> appointments = appointmentService.getPastAppointmentsForCustomer( "sam@gmail.com");
		assertTrue(appointments.size()==1);
		
	}
	
	

}
