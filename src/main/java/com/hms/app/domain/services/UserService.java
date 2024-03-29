package com.hms.app.domain.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hms.app.domain.models.Customer;
import com.hms.app.domain.models.Doctor;
import com.hms.app.domain.models.User;
import com.hms.app.domain.populators.CustomerViewDataPopulator;
import com.hms.app.domain.populators.DoctorViewDataPopulator;
import com.hms.app.domain.repository.CustomerRepository;
import com.hms.app.domain.repository.DoctorRepository;
import com.hms.app.domain.repository.UserRepository;
import com.hms.app.domain.viewdata.CustomerViewData;
import com.hms.app.domain.viewdata.DoctorViewData;
import com.hms.app.domain.viewdata.Mail;
import com.hms.app.utils.RandomPasswordGeneratorUtil;

@Service
public class UserService {
	@Resource
	private UserRepository userRepository;

	@Resource
	private CustomerRepository customerRepository;

	@Resource
	private DoctorRepository doctorRepository;

	@Resource
	private DoctorViewDataPopulator doctorViewDataPopulator;

	@Resource
	private CustomerViewDataPopulator customerViewDataPopulator;

	@Resource
	private PasswordEncoder passwordEncoder;

	@Resource
	private RandomPasswordGeneratorUtil randomPasswordGeneratorUtil;

	@Resource
	private EmailService<String> emailService;

	@Resource
	private Environment env;

	public void saveUser(User user) {
		userRepository.save(user);
	}

	public Optional<User> findUser(String id) {
		return userRepository.findUserByEmail(id);

	}

	public void saveCustomer(Customer user) {
		customerRepository.save(user);
	}

	public Optional<Customer> findCustomer(String id) {
		return customerRepository.findCustomerByEmail(id);

	}

	public void saveDoctor(Doctor user) {
		doctorRepository.save(user);
	}

	public void saveDoctorFromUser(User user) {
		Doctor doctor = new Doctor();
		doctor.setEmail(user.getEmail());
		doctor.setUserType(user.getUserType());
		doctor.setFirstName(user.getFirstName());
		doctor.setLastName(user.getLastName());
		doctor.setPassword(user.getPassword());
		doctor.setAddress(user.getAddress());
		doctor.setPhoneNo(user.getPhoneNo());
		doctor.setDesignation(null);
		doctor.setSpecialization(null);
		saveDoctor(doctor);

	}

	public void saveCustomerFromUser(User user) {
		Customer customer = new Customer();
		customer.setEmail(user.getEmail());
		customer.setUserType(user.getUserType());
		customer.setFirstName(user.getFirstName());
		customer.setLastName(user.getLastName());
		customer.setPassword(user.getPassword());
		customer.setAddress(user.getAddress());
		customer.setPhoneNo(user.getPhoneNo());
		customer.setKnownAllergies(null);

		saveCustomer(customer);
	}

	public Optional<Doctor> findDoctor(String id) {
		return doctorRepository.findDoctorByEmail(id);

	}

	public List<DoctorViewData> getAllDoctors() {
		List<Doctor> doctors = doctorRepository.findAll();

		List<DoctorViewData> doctorViewDatas = new ArrayList<>();

		doctors.forEach(doctor -> {
			DoctorViewData doctorViewData = new DoctorViewData();

			doctorViewDataPopulator.populate(doctor, doctorViewData);
			doctorViewDatas.add(doctorViewData);
		});

		return doctorViewDatas;
	}

	public DoctorViewData getDoctorViewData(String email) {
		Optional<Doctor> doctor = findDoctor(email);
		DoctorViewData doctorViewData = new DoctorViewData();
		doctorViewDataPopulator.populate(doctor.get(), doctorViewData);
		return doctorViewData;

	}

	public CustomerViewData getCustomerViewData(String email) {
		Optional<Customer> customer = findCustomer(email);
		CustomerViewData customerViewData = new CustomerViewData();
		customerViewDataPopulator.populate(customer.get(), customerViewData);
		return customerViewData;

	}

	public void resetPassword(String email) {
		Optional<User> user = findUser(email);
		if (user.isPresent()) {
			String randomPassword = randomPasswordGeneratorUtil.generateRandomPassword(Integer.parseInt(env.getProperty("mail.forgotpassword.generate.length")));
			Mail<String> mail = new Mail();
			Map<String, String> propsMap = new HashMap<>();
			propsMap.put("password", randomPassword);
			mail.setMailTo(email);
			mail.setMailProps(propsMap);
			mail.setTemplateName("email");
			mail.setMailSubject("AppCal: Password reset");
			mail.setMailContent(String.format(env.getProperty("mail.forgotpassword.text"), randomPassword));
			emailService.sendMail(mail);
			String encryptedPassword = passwordEncoder.encode(randomPassword);
			user.get().setPassword(encryptedPassword);
			saveUser(user.get());
		}
		else {
			throw new UsernameNotFoundException("No email found for id "+email);
		}
	}

}
