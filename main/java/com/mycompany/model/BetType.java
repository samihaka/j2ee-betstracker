package com.mycompany.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represents bet type available for sports.
 * 
 * @author Sami
 *
 */
@XmlRootElement
@Entity
@Table(name="bet_type")
@NamedQueries({
	@NamedQuery(name=BetType.GET_ALL_BET_TYPES, query="select bt from BetType bt order by bt.id")	
})
public class BetType {

	public static final String GET_ALL_BET_TYPES = "getBetTypes";
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    
    @Column(nullable=false, unique=true)
	private String name;
	
    @Column(name="requires_bet_target", nullable=false)
    private Boolean requiresBetTarget;
    
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

	public Boolean getRequiresBetTarget() {
		return requiresBetTarget;
	}

	public void setRequiresBetTarget(Boolean requiresBetTarget) {
		this.requiresBetTarget = requiresBetTarget;
	}

	public String toString(){
		return "Bet type id: "+this.id+" name: "+this.name;
	}
}
