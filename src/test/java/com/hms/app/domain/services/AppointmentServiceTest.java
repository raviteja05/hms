package com.hms.app.domain.services;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import com.hms.app.domain.viewdata.AppointmentViewData;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AppointmentServiceTest {
	@InjectMocks
	private AppointmentService appointmentService=new AppointmentService();
	@Mock
	private Environment env;
	@Test
	public void test1() {
		
		Mockito.when(env.getProperty("startTime")).thenReturn("08:00");
		Mockito.when(env.getProperty("endTime")).thenReturn("18:00");
		List<AppointmentViewData> appointments=appointmentService.viewAvailableAppointments("29-10-2020");
		appointments.forEach(appointment->System.out.println(appointment.getAppointmentTime()));
		
		
	}

}
