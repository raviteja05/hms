package com.hms.app.components.viewdata;

import java.util.ArrayList;
import java.util.List;

import com.hms.app.components.models.FooterSection;

public class FooterViewData {
	
	private List<FooterSectionViewData> footerSections=new ArrayList<>();
	private String copyrightText;
	public List<FooterSectionViewData> getFooterSections() {
		return footerSections;
	}
	public void setFooterSections(List<FooterSectionViewData> footerSections) {
		this.footerSections = footerSections;
	}
	public String getCopyrightText() {
		return copyrightText;
	}
	public void setCopyrightText(String copyrightText) {
		this.copyrightText = copyrightText;
	}
	

}
