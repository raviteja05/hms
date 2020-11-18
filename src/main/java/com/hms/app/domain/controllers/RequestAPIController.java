package com.hms.app.domain.controllers;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hms.app.domain.models.Customer;
import com.hms.app.domain.models.Doctor;
import com.hms.app.domain.models.Employee;
import com.hms.app.domain.models.Prescription;
import com.hms.app.domain.models.User;
import com.hms.app.domain.services.AppointmentService;
import com.hms.app.domain.services.PrescriptionService;
import com.hms.app.domain.services.UserService;
import com.hms.app.domain.viewdata.AppointmentViewData;
import com.hms.app.domain.viewdata.BookingDetailsViewData;
import com.hms.app.domain.viewdata.CustomerViewData;
import com.hms.app.domain.viewdata.DoctorViewData;
import com.hms.app.domain.viewdata.PrescriptionViewData;
import com.hms.app.utils.RandomPasswordGeneratorUtil;

@Controller
public class RequestAPIController {

	@Resource
	private AppointmentService appointmentService;
	
	@Resource
	private PrescriptionService prescriptionService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private PasswordEncoder passwordEncoder;


	@RequestMapping(path = "/app/ws/get-appointments", method = RequestMethod.GET)
	public ResponseEntity<AppointmentViewData> getAppointments(@RequestParam String date,@RequestParam String doctor) {
		List<AppointmentViewData> appointments = appointmentService.viewAvailableAppointments(date,doctor);
		return new ResponseEntity(appointments, HttpStatus.OK);

	}
	
	@RequestMapping(path = "/doc/ws/get-customerdetails", method = RequestMethod.POST)
	public ResponseEntity<CustomerViewData> getCustomerDetails(@RequestParam long appId) {
		CustomerViewData customerViewData = appointmentService.getCustomerDetailsFromAppointment(appId);
		return new ResponseEntity(customerViewData, HttpStatus.OK);

	}

	@RequestMapping(path = "/doc/ws/save-prescription", method = RequestMethod.POST)
	public ResponseEntity<String> savePrescription( @RequestBody Prescription prescription) {
		
		appointmentService.savePrescription(prescription.getCustomer().getEmail(), prescription.getDoctor().getEmail(), prescription);
		return new ResponseEntity( HttpStatus.OK);

	}
	@RequestMapping(path = {"/app/ws/get-prescriptions","/doc/ws/get-prescriptions"}, method = RequestMethod.POST)
	public ResponseEntity<List<PrescriptionViewData>> getPrescriptions( @RequestParam String custId) {
		
		
		return new ResponseEntity(prescriptionService.getAllPrescriptionsForCustomer(custId), HttpStatus.OK);

	}
	
	@RequestMapping(path = {"/app/ws/get-prescription","/doc/ws/get-prescription"}, method = RequestMethod.POST)
	public ResponseEntity<PrescriptionViewData> getPrescription( @RequestParam long prescriptionId) {
		
		
		return new ResponseEntity(prescriptionService.getPrescriptionById(prescriptionId),HttpStatus.OK);

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
	public ResponseEntity<List<AppointmentViewData>> deleteCustomerAppointement(@RequestParam long appId) {
		appointmentService.deleteAppointment(appId);
		return new ResponseEntity<List<AppointmentViewData>>(HttpStatus.OK);
	}
	
	@RequestMapping(path="/doc/ws/get-appointmentshistory",method=RequestMethod.POST)
	public ResponseEntity<List<AppointmentViewData>> getCustomerAppointementsHistory(@RequestParam String custId) {
		return new ResponseEntity<List<AppointmentViewData>>(appointmentService.getPastAppointmentsForCustomer(custId),HttpStatus.OK);
	}
	
	@RequestMapping(path="/doc/ws/update-appointmentnotes",method=RequestMethod.POST)
	public ResponseEntity<String> updateAppointment(@RequestBody AppointmentViewData appointmentViewData){
		appointmentService.updateAppointment(appointmentViewData.getId(), appointmentViewData.getAppointmentNotes());
		return new ResponseEntity<String>(HttpStatus.OK);
		
	}
	
	@RequestMapping(path="/doc/ws/update-profile",method=RequestMethod.POST)
	public ResponseEntity<String> updateDocProfile(@RequestBody Doctor doctor){
		Optional<Doctor> doc= userService.findDoctor(doctor.getEmail());
		doctor.setId(doc.get().getId());
		doctor.setPassword(doc.get().getPassword());
		doctor.setUserType(doc.get().getUserType());
		userService.saveDoctor(doctor);
		return new ResponseEntity<String>(HttpStatus.OK);
		
	}
	
	@RequestMapping(path="/app/ws/update-profile",method=RequestMethod.POST)
	public ResponseEntity<String> updateCustomerProfile(@RequestBody Customer customer){
		Optional<Customer> cust= userService.findCustomer(customer.getEmail());
		customer.setId(cust.get().getId());
		customer.setUserType(cust.get().getUserType());
		customer.setPassword(cust.get().getPassword());
		userService.saveCustomer(customer);
		return new ResponseEntity<String>(HttpStatus.OK);
		
	}
	@RequestMapping(path="/admin/ws/update-profile",method=RequestMethod.POST)
	public ResponseEntity<String> updateEmployeeProfile(@RequestBody Employee employee){
//		Optional<Employee> emp= userService.findEmployee(employee.getEmail());
//		customer.setId(cust.get().getId());
//		userService.saveCustomer(customer);
		return new ResponseEntity<String>(HttpStatus.OK);
		
	}
	
	@RequestMapping(path="/ws/update-password",method=RequestMethod.POST)
	public ResponseEntity<String> updatePassword(@RequestBody String password){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Optional<User> user= userService.findUser(authentication.getName());
		String encryptedPassword = passwordEncoder.encode(password);
		user.get().setPassword(encryptedPassword);
		userService.saveUser(user.get());
		return new ResponseEntity<String>(HttpStatus.OK);
		
	}
	
	@RequestMapping(path="/ws/reset-password",method=RequestMethod.GET)
	public String resetPassword(@RequestParam String email){
		userService.resetPassword(email);
		
		return "redirect:/login";
		
	}
	
	@RequestMapping(path="/doc/ws/get-doc-profile",method=RequestMethod.POST)
	public ResponseEntity<DoctorViewData> getDocProfile(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		DoctorViewData doctorViewData= userService.getDoctorViewData(authentication.getName());
		
		return new ResponseEntity<DoctorViewData>(doctorViewData,HttpStatus.OK);
		
	}
	
	@RequestMapping(path="/app/ws/get-pat-profile",method=RequestMethod.POST)
	public ResponseEntity<CustomerViewData> getPatientProfile(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomerViewData customerViewData= userService.getCustomerViewData(authentication.getName());
		
		return new ResponseEntity<CustomerViewData>(customerViewData,HttpStatus.OK);
		
	}
	
	
	

}
