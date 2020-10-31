package com.hms.app.domain.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.hms.app.domain.services.AppointmentService;
import com.hms.app.domain.services.UserService;
import com.hms.app.domain.viewdata.AppointmentViewData;
import com.hms.app.domain.viewdata.DoctorViewData;

@Controller
public class RequestAPIController {

	@Resource
	private AppointmentService appointmentService;
	
	@Resource
	private UserService userService;

	@RequestMapping(path = "/app/ws/get-appointments", method = RequestMethod.GET)
	public ResponseEntity<AppointmentViewData> getAppointments(@RequestParam String date,@RequestParam String doctor) {
		List<AppointmentViewData> appointments = appointmentService.viewAvailableAppointments(date,doctor);
		return new ResponseEntity(appointments, HttpStatus.OK);

	}

	@RequestMapping(path = "/app/ws/book-appointment", method = RequestMethod.POST)
	public ResponseEntity<String> bookAppointment(@RequestParam String customerId, @RequestParam String doctorId,
			@RequestParam String date) {

		appointmentService.saveAppointment(customerId, doctorId, date);
		return new ResponseEntity<String>(HttpStatus.OK);

	}
	
	@RequestMapping(path="/app/ws/list-doctors",method = RequestMethod.GET)
	public ResponseEntity<List<DoctorViewData>> getDoctors(){
		return new ResponseEntity<>(userService.getAllDoctors(),HttpStatus.OK);
	}
	



}
