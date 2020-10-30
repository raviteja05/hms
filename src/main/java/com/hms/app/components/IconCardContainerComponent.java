package com.hms.app.components;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.hms.app.components.models.IconCard;

@Entity
public class IconCardContainerComponent extends Component<IconCard>{
	@Column
	private String heading;
	@ManyToMany
	@Cascade(value = { CascadeType.SAVE_UPDATE } )
	@JoinTable(
	        name = "cardcontainericoncardrelation", 
	        joinColumns = { @JoinColumn(name="container_id")}, 
	        inverseJoinColumns = { @JoinColumn(name = "card_id") }
	    )	
	private List<IconCard> contentCards=new ArrayList<>();

	public List<IconCard> getContentCards() {
		return contentCards;
	}

	public void setContentCards(List<IconCard> contentCards) {
		this.contentCards = contentCards;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}
	
	
	
	

}
