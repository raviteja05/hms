package com.hms.app.domain.services;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import com.hms.app.domain.models.Customer;
import com.hms.app.domain.models.Doctor;
import com.hms.app.domain.models.User;
import com.hms.app.domain.models.UserType;
import com.hms.app.domain.viewdata.CustomerViewData;
import com.hms.app.domain.viewdata.DoctorViewData;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserServiceTest {
	
	@Resource
	private UserService userService;
	
	@Test
	@Order(1)
	public void testSaveUser() {
		User user=new User();
		user.setAddress("16 Mill St, London,W116TH");
		user.setFirstName("Anjan");
		user.setLastName("Kumar");
		user.setPhoneNo("08978677856");
		user.setEmail("anjan.p@gmail.com");
		userService.saveUser(user);
		
	}
	
	@Test
	@Order(2)
	public void testSaveDoctor() {
		Doctor user=new Doctor();
		user.setAddress("27 Academy, London,W116JU");
		user.setFirstName("Sam");
		user.setLastName("Wolf");
		user.setPhoneNo("08978678856");
		user.setEmail("sam.w@gmail.com");
		user.setDesignation("Neurologist");
		user.setQualification("MBBS");
		user.setUserType(UserType.DOCTOR);
		
		userService.saveDoctor(user);	
		
	}
	
	@Test
	@Order(3)
	public void testSaveCustomer() {
		Customer user=new Customer();
		user.setAddress("27 Chertsey close, London,W116JU");
		user.setFirstName("Harry");
		user.setLastName("Bond");
		user.setPhoneNo("08978677856");
		user.setEmail("harry.b@gmail.com");
		user.setBloodGroup("B+");
		user.setAge(45);
		user.setUserType(UserType.CUSTOMER);
		
		userService.saveCustomer(user);	
		
	}
	
	@Test
	@Order(4)
	public void testFindUser() {
		Optional<User> user=userService.findUser("anjan.p@gmail.com");
		assertTrue(user.isPresent());
		
	}
	
	@Test
	@Order(5)
	public void testFindUserNotExists() {
		Optional<User> user=userService.findUser("mary@gmail.com");
		assertTrue(user.isEmpty());
	}
	
	
	
	@Test
	@Order(6)
	public void testFindCustomer() {
				
		Optional<Customer> user=userService.findCustomer("harry.b@gmail.com");	
		assertTrue(user.isPresent());
	}
	

	
	@Test
	@Order(7)
	public void testFindDoctor() {
				
		Optional<Doctor> user=userService.findDoctor("sam.w@gmail.com");	
		assertTrue(user.isPresent());
	}
	
	@Test
	@Order(8)
	public void testGetAllDoctors() {
		List<DoctorViewData> doctorViewDatas=userService.getAllDoctors();
		
		assertTrue(doctorViewDatas.size()==1);
		assertTrue(doctorViewDatas.get(0).getEmail().equals("sam.w@gmail.com"));
		
		
	}
	
	@Test
	@Order(9)
	public void testGetCustomerViewData() {
		CustomerViewData customerViewData=userService.getCustomerViewData("harry.b@gmail.com");
		
		
		assertTrue(customerViewData.getEmail().equals("harry.b@gmail.com"));
		assertTrue(customerViewData.getLastName().equals("Bond"));
		
		
	}
	
	
	
	

}
