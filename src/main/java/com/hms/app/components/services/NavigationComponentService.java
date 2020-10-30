package com.hms.app.components.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hms.app.components.NavigationBarComponent;
import com.hms.app.components.repositories.NavigationBarComponentRepository;

@Service
public class NavigationComponentService implements ComponentService<NavigationBarComponent>{
	@Resource
	private NavigationBarComponentRepository navigationBarComponentRepository;
	
	@Override
	public void createComponent(NavigationBarComponent navBarComponentData) {
		navigationBarComponentRepository.save(navBarComponentData);	
		
	}
	@Override
	public NavigationBarComponent getComponent(String id) {
		return navigationBarComponentRepository.getOne(id);
	}

	

}
