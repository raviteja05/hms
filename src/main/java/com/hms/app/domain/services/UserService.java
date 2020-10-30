package com.hms.app.domain.services;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hms.app.domain.models.Customer;
import com.hms.app.domain.models.Doctor;
import com.hms.app.domain.models.User;
import com.hms.app.domain.repository.CustomerRepository;
import com.hms.app.domain.repository.DoctorRepository;
import com.hms.app.domain.repository.UserRepository;

@Service
public class UserService {
	@Resource
	private UserRepository userRepository;
	
	@Resource
	private CustomerRepository customerRepository;
	
	@Resource
	private DoctorRepository doctorRepository;
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public Optional<User> findUser(String id) {
		return userRepository.findById(id);
		
	}
	
	public void saveCustomer(Customer user) {
		customerRepository.save(user);
	}
	
	public Optional<Customer> findCustomer(String id) {
		return customerRepository.findById(id);
		
	}
	
	public void saveDoctor(Doctor user) {
		doctorRepository.save(user);
	}
	
	public Optional<Doctor> findDoctor(String id) {
		return doctorRepository.findById(id);
		
	}

}
