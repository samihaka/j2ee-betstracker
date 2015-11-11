package com.mycompany.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * This class represents event that bet is related to to.
 * 
 * @author Sami
 *
 */
@Entity
@Table(name="event")
@NamedQueries(
	@NamedQuery(name=Event.GET_EVENT_BY_NAME, query="select e from Event e where UPPER(e.name) = :name")	
)
public class Event {
    public static final String GET_EVENT_BY_NAME = "getEventByName";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    
    @Column(nullable=false, unique=true)
	private String name;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="sport_id", nullable=false, referencedColumnName="id")
    private Sport sport;
    
	public Event(){
		sport = new Sport();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public String toString(){
		return "Id: "+this.id +" name: "+this.name;
	}
}
