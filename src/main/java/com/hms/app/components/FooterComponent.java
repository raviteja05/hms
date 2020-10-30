package com.hms.app.components;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.hms.app.components.models.FooterSection;

@Entity
public class FooterComponent extends Component<FooterSection>{
	
	@OneToMany
	@Cascade( value = { CascadeType.SAVE_UPDATE })
	private List<FooterSection> footerSections;
	
	@Column
	private String copyrightText;

	public List<FooterSection> getFooterSections() {
		return footerSections;
	}

	public void setFooterSections(List<FooterSection> footerSections) {
		this.footerSections = footerSections;
	}

	public String getCopyrightText() {
		return copyrightText;
	}

	public void setCopyrightText(String copyrightText) {
		this.copyrightText = copyrightText;
	}
}
