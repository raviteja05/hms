package com.hms.app.pages.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.hms.app.components.Component;
@Entity
public class Page {
	@Id
	private String pageId;
	@ManyToMany
	@Cascade(value = { CascadeType.SAVE_UPDATE } )
	@JoinTable(
	        name = "Pagecomponentrelation", 
	        joinColumns = { @JoinColumn(name="pid")}, 
	        inverseJoinColumns = { @JoinColumn(name = "cid") }
	    )	
	private List<Component> components=new ArrayList<>();
	public String getPageId() {
		return pageId;
	}
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	public List<Component> getComponents() {
		return components;
	}
	public void setComponents(List<Component> components) {
		this.components = components;
	}
	

}
