package com.mycompany.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * This class represents single bet with specific bet type for specific event.
 * 
 * @author Sami
 *
 */
@Entity
@Table(name="bet")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    
    @Column(name="bet_date", nullable=false)
	private Date betDate;
    
    @Column(nullable=false)
	private String participant1;
	private String participant2;
	
	@ManyToOne
	private Event betEvent;
	
	@ManyToOne
	private BetType betType;
	
	@Column(name="bet_target", nullable=false)
	private String betTarget;
	
    @Column(name="bet_amount", nullable=false)		
	private float betAmount;
    
    @Column(name="bet_return", nullable=false)	
	private float betReturn;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getBetDate() {
		return betDate;
	}
	
	public void setBetDate(Date betDate) {
		this.betDate = betDate;
	}
	
	public Event getBetEvent() {
		return betEvent;
	}

	public void setBetEvent(Event betEvent) {
		this.betEvent = betEvent;
	}
	
	public String getParticipant1() {
		return participant1;
	}

	public void setParticipant1(String participant1) {
		this.participant1 = participant1;
	}

	public String getParticipant2() {
		return participant2;
	}

	public void setParticipant2(String participant2) {
		this.participant2 = participant2;
	}
	
/*	public BetType getBetType() {
		return betType;
	}
	
	public void setBetType(BetType betType) {
		this.betType = betType;
	}
*/	
	
	public String getBetTarget() {
		return betTarget;
	}

	public void setBetTarget(String betTarget) {
		this.betTarget = betTarget;
	}
	
	public float getBetAmount() {
		return betAmount;
	}
	
	public void setBetAmount(float betAmount) {
		this.betAmount = betAmount;
	}
	
	public float getBetReturn() {
		return betReturn;
	}
	
	public void setBetReturn(float betReturn) {
		this.betReturn = betReturn;
	}
}
