package com.hms.app.data.setup;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hms.app.pages.services.PageService;
import com.hms.app.utils.JsonUtils;
@Component
public class SiteWidePageDataHandler implements DataHandler {
	@Resource
	private PageService pageService;

	
	@Resource
	private AnonymousPageDataHandler anonymousPageDataHandler;
	@Resource
	private DashBoardPageDataHandler dashBoardPageDataHandler;
	
	
	@Resource
	private JsonUtils jsonUtils;

	@Override
	public void setUp() {
		anonymousPageDataHandler.setUp();
		dashBoardPageDataHandler.setUp();

		
		
	}


}
