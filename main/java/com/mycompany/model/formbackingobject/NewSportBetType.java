package com.mycompany.model.formbackingobject;

/**
 * This is form backing object for linking bet type to sport.
 * 
 * @author Sami
 *
 */
public class NewSportBetType {
	private String sportName;
	private int betTypeId;
	
	public String getSportName() {
		return sportName;
	}
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
	public int getBetTypeId() {
		return betTypeId;
	}
	public void setBetTypeId(int betTypeId) {
		this.betTypeId = betTypeId;
	}
	
	public String toString(){
		return "Sport name: "+this.sportName+" bet type id: "+this.betTypeId;
	}
}
