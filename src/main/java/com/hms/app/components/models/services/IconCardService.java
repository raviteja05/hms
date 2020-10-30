package com.hms.app.components.models.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hms.app.components.models.IconCard;
import com.hms.app.components.models.repository.IconCardRepository;
import com.hms.app.components.services.ComponentService;
@Service
public class IconCardService implements ComponentService<IconCard> {
	@Resource
	private IconCardRepository iconCardRepository;

	@Override
	public void createComponent(IconCard component) {
		iconCardRepository.save(component);	
	}
	
	
	public void createComponents(List<IconCard> components) {
		iconCardRepository.saveAll(components);	
	}

	@Override
	public IconCard getComponent(String id) {
		
		return iconCardRepository.getOne(id);
	}

}
