package com.mycompany.model.formbackingobject;

public class NewEvent {

	private String name;
	private int sportId;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getSportId() {
		return sportId;
	}
	
	public void setSportId(int sportId) {
		this.sportId = sportId;
	}
	
	public String toString(){
		return "Id: "+this.sportId+" name: "+this.name;
	}
}
