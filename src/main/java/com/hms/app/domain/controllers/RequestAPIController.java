package com.hms.app.domain.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hms.app.domain.models.Prescription;
import com.hms.app.domain.services.AppointmentService;
import com.hms.app.domain.services.PrescriptionService;
import com.hms.app.domain.services.UserService;
import com.hms.app.domain.viewdata.AppointmentViewData;
import com.hms.app.domain.viewdata.BookingDetailsViewData;
import com.hms.app.domain.viewdata.CustomerViewData;
import com.hms.app.domain.viewdata.DoctorViewData;
import com.hms.app.domain.viewdata.PrescriptionViewData;

@Controller
public class RequestAPIController {

	@Resource
	private AppointmentService appointmentService;
	
	@Resource
	private PrescriptionService prescriptionService;
	
	@Resource
	private UserService userService;

	@RequestMapping(path = "/app/ws/get-appointments", method = RequestMethod.GET)
	public ResponseEntity<AppointmentViewData> getAppointments(@RequestParam String date,@RequestParam String doctor) {
		List<AppointmentViewData> appointments = appointmentService.viewAvailableAppointments(date,doctor);
		return new ResponseEntity(appointments, HttpStatus.OK);

	}
	
	@RequestMapping(path = "/doc/ws/get-customerdetails", method = RequestMethod.POST)
	public ResponseEntity<CustomerViewData> getCustomerDetails(@RequestParam String appId) {
		CustomerViewData customerViewData = appointmentService.getCustomerDetailsFromAppointment(appId);
		return new ResponseEntity(customerViewData, HttpStatus.OK);

	}

	@RequestMapping(path = "/doc/ws/save-prescription", method = RequestMethod.POST)
	public ResponseEntity<String> savePrescription( @RequestBody Prescription prescription) {
		
		appointmentService.savePrescription(prescription.getCustomer().getEmail(), prescription.getDoctor().getEmail(), prescription);
		return new ResponseEntity( HttpStatus.OK);

	}
	@RequestMapping(path = {"/app/ws/get-prescriptions","/doc/ws/get-prescriptions"}, method = RequestMethod.POST)
	public ResponseEntity<List<PrescriptionViewData>> getPrescription( @RequestParam String custId) {
		
		
		return new ResponseEntity(prescriptionService.getAllPrescriptionsForCustomer(custId), HttpStatus.OK);

	}

	@RequestMapping(path = "/app/ws/book-appointment", method = RequestMethod.POST)
	public ResponseEntity<String> bookAppointment(@RequestParam String customerId, @RequestParam String doctorId,
			@RequestParam String date) {

		BookingDetailsViewData bookingDetailsViewData=appointmentService.saveAppointment(customerId, doctorId, date);
		if(bookingDetailsViewData==null) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<String>(HttpStatus.OK);

	}
	
	@RequestMapping(path="/app/ws/list-doctors",method = RequestMethod.GET)
	public ResponseEntity<List<DoctorViewData>> getDoctors(){
		return new ResponseEntity<>(userService.getAllDoctors(),HttpStatus.OK);
	}
	
	@RequestMapping(path="/doc/ws/my-appointments",method=RequestMethod.POST)
	public ResponseEntity<List<AppointmentViewData>> getDocAppointments(@RequestParam String docId) {
		return new ResponseEntity<List<AppointmentViewData>>(appointmentService.getAppointmentsForDoctor(docId),HttpStatus.OK);
	}
	
	@RequestMapping(path="/app/ws/my-appointments",method=RequestMethod.POST)
	public ResponseEntity<List<AppointmentViewData>> getCustomerAppointements(@RequestParam String custId) {
		return new ResponseEntity<List<AppointmentViewData>>(appointmentService.getAppointmentsForCustomer(custId),HttpStatus.OK);
	}
	
	@RequestMapping(path="/app/ws/delete-appointment",method=RequestMethod.POST)
	public ResponseEntity<List<AppointmentViewData>> deleteCustomerAppointement(@RequestParam String appId) {
		appointmentService.deleteAppointment(appId);
		return new ResponseEntity<List<AppointmentViewData>>(HttpStatus.OK);
	}
	
	



}
