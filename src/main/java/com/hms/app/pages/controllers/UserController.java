package com.hms.app.pages.controllers;

import java.security.Principal;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.core.env.Environment;
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
	
	@Resource
	private Environment env;

	@PostMapping(path = "/signup", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String doRegister(@ModelAttribute User user) {

		Optional<User> dbUser = userService.findUser(user.getEmail());
		if (dbUser.isEmpty()) {

			String encryptedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encryptedPassword);

			user.setUserType(UserType.CUSTOMER);
			userService.saveCustomerFromUser(user);

		}else {
			return "redirect:/signup?error";
		}

		return "redirect:/signup?success";

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

		else {
			return "redirect:/signup?error";
		}

		return "redirect:/signup?success";

	}
	@GetMapping(path = "/signup")
	public ModelAndView getRegisterPage(String error, String success) {
		ModelAndView mv = new ModelAndView();
		try {
			pageService.getPage("signup");
			mv.addObject("pageData", pageService.getPageData("signup"));
			mv.addObject("pageId", "signup");
			if (error != null) {
	            mv.addObject("error", env.getProperty("message.register.error"));
	        }
	        else {
	        	mv.addObject("error", "");
	        }
	        if (success != null) {
	            mv.addObject("msg", env.getProperty("message.register.success"));
	        }else {
	        	 mv.addObject("msg", "");
	        }
			mv.setViewName("index");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("pageData", pageService.getPageData("404page"));
			mv.addObject("pageId", "404");
			mv.setViewName("index");
		}
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView mv, String error, String logout) {
		
		try {
			pageService.getPage("login");
			mv.addObject("pageData", pageService.getPageData("login"));
			
			mv.addObject("pageId", pageService.checkPageLabelPreconditions("login"));
			mv.setViewName("index");
		}catch(Exception e) {
			e.printStackTrace();
			mv.addObject("pageData", pageService.getPageData("404"));
			mv.addObject("pageId", "404");
			mv.setViewName("index");
		}
        if (error != null) {
            mv.addObject("error", env.getProperty("message.login.error"));
        }
        else {
        	mv.addObject("error", "");
        }
        if (logout != null) {
            mv.addObject("msg", env.getProperty("message.logout.success"));
        }else {
        	 mv.addObject("msg", "");
        }

        return mv;
    }

	@RequestMapping(value = "/username", method = RequestMethod.GET)
	@ResponseBody
	public String currentUserName(Principal principal) {
		return principal.getName();
	}

}
