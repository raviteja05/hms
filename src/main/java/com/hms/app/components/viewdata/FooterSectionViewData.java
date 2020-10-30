package com.hms.app.components.viewdata;

import java.util.ArrayList;
import java.util.List;

public class FooterSectionViewData {
	private String sectionHeader;
	private List<NavigationLinkViewData> footerLinks=new ArrayList<>();
	public String getSectionHeader() {
		return sectionHeader;
	}
	public void setSectionHeader(String sectionHeader) {
		this.sectionHeader = sectionHeader;
	}
	public List<NavigationLinkViewData> getFooterLinks() {
		return footerLinks;
	}
	public void setFooterLinks(List<NavigationLinkViewData> footerLinks) {
		this.footerLinks = footerLinks;
	}
	
}
