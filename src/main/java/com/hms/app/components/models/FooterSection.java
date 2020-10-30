package com.hms.app.components.models;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class FooterSection {
	
	@Id
	private String id;
	
	@Column
	private String sectionHeader;
	
	@OneToMany
	@Cascade( value = { CascadeType.SAVE_UPDATE })
	private List<NavigationLink> footerLinks;

	public String getSectionHeader() {
		return sectionHeader;
	}

	public void setSectionHeader(String sectionHeader) {
		this.sectionHeader = sectionHeader;
	}

	public List<NavigationLink> getFooterLinks() {
		return footerLinks;
	}

	public void setFooterLinks(List<NavigationLink> footerLinks) {
		this.footerLinks = footerLinks;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	

}
