package com.hms.app.components.populators;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hms.app.components.NavigationBarComponent;
import com.hms.app.components.models.NavigationLink;
import com.hms.app.components.viewdata.NavigationLinkViewData;
import com.hms.app.components.viewdata.NavigationViewData;
import com.hms.app.populator.Populator;

@Component
public class NavigationViewDataPopulator implements Populator<NavigationBarComponent, NavigationViewData>{

	@Override
	public void populate(NavigationBarComponent source, NavigationViewData target) {
		
		source.getNavigationBar().getNavigationLinks().forEach(navLink->populateNavLinks(navLink,target.getNavigationLinks()));
		
	}

	private void populateNavLinks(NavigationLink navLink,
			List<NavigationLinkViewData> navigationLinks) {
		NavigationLinkViewData navLinkViewData=new NavigationLinkViewData();
		navLinkViewData.setName(navLink.getLinkText());
		navLinkViewData.setUrl(navLink.getUrl());
		
		navigationLinks.add(navLinkViewData);
		
	}

}
