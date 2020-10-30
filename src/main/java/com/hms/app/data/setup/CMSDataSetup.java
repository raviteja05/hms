package com.hms.app.data.setup;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.hms.app.domain.models.User;
import com.hms.app.domain.models.UserType;
import com.hms.app.domain.services.UserService;

@Component
public class CMSDataSetup {

	@Resource
	private SiteWideComponentsDataHandler siteWideComponentsDataHandler;

	@Resource
	private SiteWidePageDataHandler siteWidePageDataHandler;
	@Resource
	private Environment env;

	@Resource
	private UserService userService;

	@Resource
	private PasswordEncoder passwordEncoder;

	@PostConstruct
	public void initialize() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (env.getProperty("site.initialize").equals("true") ||checkIfAdmin(authentication)) {
			siteWideComponentsDataHandler.setUp();
			siteWidePageDataHandler.setUp();

			createAdminUser();
		}

	}

	private boolean checkIfAdmin(Authentication authentication) {
		return authentication!=null&& authentication.getAuthorities().toString().contains("ADMIN");
	}

	private void createAdminUser() {
		User user = new User();
		user.setFirstName("Administrator");
		user.setUserType(UserType.ADMIN);
		user.setEmail(env.getProperty("admin.username"));
		user.setPassword(passwordEncoder.encode(env.getProperty("admin.password")));

		userService.saveUser(user);

	}

}
