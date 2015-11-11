package com.mycompany.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sport")
@NamedQueries({
	@NamedQuery(name=Sport.GET_ALL_SPORTS, query="select s from Sport s order by s.id"),
	@NamedQuery(name=Sport.GET_SPORT_BY_NAME, query="select s from Sport s where UPPER(s.name) = :name")	
})
public class Sport {
	
	public static final String GET_ALL_SPORTS = "getSports";
    public static final String GET_SPORT_BY_NAME = "getSportByName";
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
    @Column(nullable=false, unique=true)
	private String name;
    
    @OneToMany(mappedBy="sport", cascade=CascadeType.ALL)
    private List<Event> events = new ArrayList<Event>();

    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="sport_bet_type", 
    		   joinColumns=@JoinColumn(name="sport_id", nullable=false),
    		   inverseJoinColumns=@JoinColumn(name="bet_type_id", nullable=false))
    private List<BetType> betTypes = new ArrayList<BetType>();
    
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
	
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

    public List<BetType> getBetTypes() {
		return betTypes;
	}

	public void setBetTypes(List<BetType> betTypes) {
		this.betTypes = betTypes;
	}
	
	public String toString(){
		return "Id: "+this.id +" name: "+this.name;
	}
}
