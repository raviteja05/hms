package com.hms.app.domain.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hms.app.domain.services.AppointmentService;
import com.hms.app.domain.viewdata.AppointmentViewData;

@Controller
public class RequestAPIController {

	@Resource
	private AppointmentService appointmentService;

	@RequestMapping(path = "/app/ws/get-appointments", method = RequestMethod.GET)
	public ResponseEntity<AppointmentViewData> getAppointments(@RequestParam String date) {
		List<AppointmentViewData> appointments = appointmentService.viewAvailableAppointments(date);
		return new ResponseEntity(appointments, HttpStatus.OK);

	}

	@RequestMapping(path = "/app/ws/book-appointment", method = RequestMethod.POST)
	public ResponseEntity<String> bookAppointment(@RequestParam String customerId, @RequestParam String doctorId,
			@RequestParam String date) {

		appointmentService.saveAppointment(customerId, doctorId, date);
		return new ResponseEntity<String>(HttpStatus.OK);

	}

}
