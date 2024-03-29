package com.hms.app.pages.controllers;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hms.app.components.populators.NavigationViewDataPopulator;
import com.hms.app.components.services.NavigationComponentService;
import com.hms.app.components.viewdata.NavigationViewData;
import com.hms.app.data.setup.CMSDataSetup;
import com.hms.app.pages.services.PageService;

@Controller
public class AbstractPageController {
	@Resource
	private CMSDataSetup cMSDataSetup;

	@Resource
	private PageService pageService;
	@Resource
	private NavigationComponentService navigationComponentService;
	@Resource
	private NavigationViewDataPopulator navigationViewDataPopulator;

	@RequestMapping(path = "/{pageLabel}", method = RequestMethod.GET)
	public ModelAndView getPage(@PathVariable(required = false) String pageLabel) {
		ModelAndView mv = processPage(pageLabel);
		return mv;

	}
	
	@RequestMapping(path = "/contact-us", method = RequestMethod.GET)
	public ModelAndView getContactUsPage(String success) {
		ModelAndView mv = processPage("contact-us");
		if(success!=null) {
			mv.addObject("msg","Feedback submitted successfully");
		}
		return mv;

	}
	
	@RequestMapping(path = "/app/{pageLabel}", method = RequestMethod.GET)
	public ModelAndView getPagesForPatient(@PathVariable(required = false) String pageLabel,@ModelAttribute("flashAttributes") Object flashAttr) {
		
		ModelAndView mv = processPage(pageLabel);
		
		return mv;

	}
	@RequestMapping(path = "/admin/{pageLabel}", method = RequestMethod.GET)
	public ModelAndView getPagesForAdmin(@PathVariable(required = false) String pageLabel) {
		ModelAndView mv = processPage(pageLabel);
		return mv;

	}
	@RequestMapping(path = "/doc/{pageLabel}", method = RequestMethod.GET)
	public ModelAndView getPagesForDoctor(@PathVariable(required = false) String pageLabel) {
		ModelAndView mv = processPage(pageLabel);
		
		return mv;

	}

	private ModelAndView processPage(String pageLabel) {
		ModelAndView mv = new ModelAndView();
		try {
			pageService.getPage(pageLabel);
			mv.addObject("pageData", pageService.getPageData(pageLabel));
			mv.addObject("pageId", pageService.checkPageLabelPreconditions(pageLabel));
			mv.setViewName("index");
		}catch(Exception e) {
			e.printStackTrace();
			mv.addObject("pageData", pageService.getPageData("404"));
			mv.addObject("pageId", "404");
			mv.setViewName("index");
		}
		return mv;
	}
	



	@RequestMapping(path = "/admin/initialize", method = RequestMethod.GET)
	public ModelAndView get() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("pageData", pageService.getPageData("admin-dashboard"));
		mv.addObject("pageId", pageService.checkPageLabelPreconditions("admin-dashboard"));
		mv.setViewName("index");
		cMSDataSetup.initialize();
		
		return mv;

	}

}
