package com.hms.app.components.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hms.app.components.IconCardContainerComponent;
import com.hms.app.components.repositories.IconCardContainerComponentRepository;
@Service
public class IconCardContainerComponentService implements ComponentService<IconCardContainerComponent> {
	@Resource
	private IconCardContainerComponentRepository iconCardContainerComponentRepository;

	@Override
	public void createComponent(IconCardContainerComponent component) {
		iconCardContainerComponentRepository.save(component);
		
	}

	@Override
	public IconCardContainerComponent getComponent(String id) {
		return iconCardContainerComponentRepository.getOne(id);
	}

}
