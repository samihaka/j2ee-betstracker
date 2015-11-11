package com.mycompany.model.exception;

public class DBException extends Exception{
	private static final long serialVersionUID = 1L;
	private String reason;
	
	public DBException(String reason){
		this.reason = reason;
	}
	
	public String getReason(){
		return reason;
	}

}
