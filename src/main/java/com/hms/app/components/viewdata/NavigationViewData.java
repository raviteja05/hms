package com.hms.app.components.viewdata;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class NavigationViewData {
	private List<NavigationLinkViewData> navigationLinks=new ArrayList<>();

	public List<NavigationLinkViewData> getNavigationLinks() {
		return navigationLinks;
	}

	public void setNavigationLinks(List<NavigationLinkViewData> navigationLinks) {
		this.navigationLinks = navigationLinks;
	}
	

}
