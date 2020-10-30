package com.hms.app.domain.security.services;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hms.app.domain.models.User;
import com.hms.app.domain.repository.UserRepository;
import com.hms.app.domain.security.AppUserDetails;

@Service
public class AppUserDetailsService implements UserDetailsService {
	@Resource
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		AppUserDetails appUserDetails = new AppUserDetails();
		appUserDetails.setUser(user);
		return appUserDetails;
	}

}
