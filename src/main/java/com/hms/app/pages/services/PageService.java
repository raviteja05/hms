package com.hms.app.pages.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.hms.app.components.Component;
import com.hms.app.components.services.ComponentService;
import com.hms.app.domain.models.User;
import com.hms.app.domain.services.UserService;
import com.hms.app.pages.constants.CMSConstants;
import com.hms.app.pages.models.Page;
import com.hms.app.pages.repository.PageRepository;
import com.hms.app.populator.Populator;
import com.hms.app.utils.AppObjectFactory;

@Service
public class PageService {

	@Resource
	private PageRepository pageRepository;

	@Resource
	private Map<String, ComponentService> componentServices;

	@Resource
	private Map<String, Populator> componentPopulators;
	
	@Resource
	private UserService userService;

	public void createPage(Page page) {
		pageRepository.save(page);
	}

	public void createPages(List<Page> pages) {
		pageRepository.saveAll(pages);
	}

	public Page getPage(String id) {
		

		return pageRepository.getOne(id);
	}
	
	public String getDynamicPageFlashAttributes(String pageLabel,Object object) {
		String jsonData = null;
		if(pageLabel.equals("view-appointments")) {
			try {
				jsonData=new ObjectMapper().writeValueAsString(object);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return jsonData;
		
	}

	public JsonObject getPageData(String id) {
		JsonObject jsonObject = new JsonObject();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		getPage(id).getComponents().forEach(component -> populateComponentData(component, jsonObject));
		JsonObject authObject = new JsonObject();
		Optional<User> user=null;
		if (authentication != null && authentication.getName() != null) {
			if (authentication.getName().equals("anonymousUser")) {
				authObject.addProperty("isLoggedIn", false);
			} else {
				authObject.addProperty("isLoggedIn", true);
				user=userService.findUser(authentication.getName());
			}
			authObject.addProperty("user", authentication.getName());
			if(authentication.getAuthorities().toString().contains("ADMIN")) {
				
				authObject.addProperty("role", "ADMIN");
				authObject.addProperty("name",String.format("%s %s", user.get().getFirstName(),user.get().getLastName()) );
			}else if(authentication.getAuthorities().toString().contains("CUSTOMER")) {
				
				authObject.addProperty("role", "CUSTOMER");
				authObject.addProperty("name",String.format("%s %s", user.get().getFirstName(),user.get().getLastName()) );
			}else if(authentication.getAuthorities().toString().contains("DOCTOR")) {
				
				authObject.addProperty("role", "DOCTOR");
				authObject.addProperty("name",String.format("%s %s", user.get().getFirstName(),user.get().getLastName()) );
			}
		}

		jsonObject.add("auth", authObject);

		return jsonObject;

	}
	
	public String checkPageLabelPreconditions(String pageLabel) {
		if(pageLabel!=null &&CMSConstants.DASHBOARD_PAGES.contains(pageLabel)) {
			return CMSConstants.DASHBOARD;
		}
		return pageLabel;
		
	}
	
	private void populateComponentData(Component component, JsonObject jsonObject) {
		AppObjectFactory viewDataObjectFactory = new AppObjectFactory();
		Object data = viewDataObjectFactory.createViewDataObject(component.getComponentType());
		JsonElement element = null;
		componentPopulators.get(component.getComponentType()).populate(
				componentServices.get(component.getComponentType()).getComponent(component.getComponentId()), data);

		try {
			element = JsonParser.parseString(new ObjectMapper().writeValueAsString(data));
		} catch (JsonSyntaxException | JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsonObject.add(component.getComponentType(), element);
	}
	
	

}
