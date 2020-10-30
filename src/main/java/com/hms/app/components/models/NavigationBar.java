package com.hms.app.components.models;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class NavigationBar {
	
	@Id
	private String id;
	
	@OneToMany
	@Cascade( value = { CascadeType.SAVE_UPDATE})
	private List<NavigationLink> navigationLinks;

	public List<NavigationLink> getNavigationLinks() {
		return navigationLinks;
	}

	public void setNavigationLinks(List<NavigationLink> navigationLinks) {
		this.navigationLinks = navigationLinks;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	

}
