package com.hms.app.components.models.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hms.app.components.models.NavigationBar;
import com.hms.app.components.models.repository.NavigationBarRepository;
import com.hms.app.components.services.ComponentService;
@Service
public class NavigationBarService implements ComponentService<NavigationBar>{
	@Resource
	private NavigationBarRepository navigationBarRepository;

	@Override
	public void createComponent(NavigationBar component) {
		navigationBarRepository.save(component);
		
	}

	@Override
	public NavigationBar getComponent(String id) {
		
		return navigationBarRepository.getOne(id);
	}

}
