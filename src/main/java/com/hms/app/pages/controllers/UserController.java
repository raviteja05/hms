package com.hms.app.pages.controllers;

import java.security.Principal;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hms.app.domain.models.User;
import com.hms.app.domain.models.UserType;
import com.hms.app.domain.services.UserService;
import com.hms.app.pages.services.PageService;

@Controller
public class UserController {
	@Resource
	private PasswordEncoder passwordEncoder;
	@Resource
	private UserService userService;
	@Resource
	private AuthenticationProvider authenticationProvider;

	@Resource
	private PageService pageService;

	@PostMapping(path = "/signup", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String doRegister(@ModelAttribute User user) {

		Optional<User> dbUser = userService.findUser(user.getEmail());
		if (dbUser.isEmpty()) {

			String encryptedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encryptedPassword);

			user.setUserType(UserType.CUSTOMER);
			userService.saveCustomerFromUser(user);

		}

		return "redirect:/signup";

	}

	@PostMapping(path = "/admin/signup", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String doAdminRegister(@ModelAttribute User user) {

		Optional<User> dbUser = userService.findUser(user.getEmail());
		if (dbUser.isEmpty()) {

			String encryptedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encryptedPassword);
			if(user.getUserType().equals(UserType.DOCTOR)) {
				user.setUserType(UserType.DOCTOR);
				userService.saveDoctorFromUser(user);
				
			}else if(user.getUserType().equals(UserType.CUSTOMER)) {
				user.setUserType(UserType.CUSTOMER);
				userService.saveCustomerFromUser(user);
				
			}else if(user.getUserType().equals(UserType.ADMIN)){
				user.setUserType(UserType.ADMIN);
				userService.saveUser(user);
			}
			

		}

		return "redirect:/signup";

	}
	@GetMapping(path = "/signup")
	public ModelAndView getRegisterPage() {
		ModelAndView mv = new ModelAndView();
		try {
			pageService.getPage("signup");
			mv.addObject("pageData", pageService.getPageData("signup"));
			mv.addObject("pageId", "signup");
			mv.setViewName("index");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("pageData", pageService.getPageData("404page"));
			mv.addObject("pageId", "404");
			mv.setViewName("index");
		}
		return mv;
	}

	@RequestMapping(value = "/username", method = RequestMethod.GET)
	@ResponseBody
	public String currentUserName(Principal principal) {
		return principal.getName();
	}

}
