package com.hms.app.components.populators;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hms.app.components.FooterComponent;
import com.hms.app.components.models.FooterSection;
import com.hms.app.components.models.NavigationLink;
import com.hms.app.components.viewdata.FooterSectionViewData;
import com.hms.app.components.viewdata.FooterViewData;
import com.hms.app.components.viewdata.NavigationLinkViewData;
import com.hms.app.populator.Populator;
@Component
public class FooterViewDataPopulator implements Populator<FooterComponent,FooterViewData> {

	@Override
	public void populate(FooterComponent source, FooterViewData target) {
		target.setCopyrightText(source.getCopyrightText());
		source.getFooterSections().forEach(footerSection->populateFooterSection(footerSection,target.getFooterSections()));
		
	}

	private void populateFooterSection(FooterSection footerSection, List<FooterSectionViewData> footerSections) {
		FooterSectionViewData footerSectionViewData=new FooterSectionViewData();
		footerSection.getFooterLinks().forEach(footerLink->populateFooterLinks(footerLink,footerSectionViewData));
		footerSectionViewData.setSectionHeader(footerSection.getSectionHeader());
		footerSections.add(footerSectionViewData);
	}

	private void populateFooterLinks(NavigationLink footerLink, FooterSectionViewData footerSectionViewData) {
		NavigationLinkViewData navigationLinkViewData=new NavigationLinkViewData();
		
		navigationLinkViewData.setName(footerLink.getLinkText());
		navigationLinkViewData.setUrl(footerLink.getUrl());
		footerSectionViewData.getFooterLinks().add(navigationLinkViewData);
		
	}

}
