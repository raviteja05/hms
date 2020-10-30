package com.hms.app.components.models.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hms.app.components.models.NavigationLink;
import com.hms.app.components.models.repository.NavigationLinkRepository;
import com.hms.app.components.services.ComponentService;
@Service
public class NavigationLinkService implements ComponentService<NavigationLink> {
	
	@Resource
	private NavigationLinkRepository navigationLinkRepository;

	@Override
	public void createComponent(NavigationLink component) {
		navigationLinkRepository.save(component);
		
	}
	
	public void createComponents(List<NavigationLink> components) {
		navigationLinkRepository.saveAll(components);
	}

	@Override
	public NavigationLink getComponent(String id) {
		return navigationLinkRepository.getOne(id);
	}

}
