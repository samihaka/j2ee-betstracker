package com.mycompany.service;

import java.util.List;

import com.mycompany.model.Sport;

public interface SportService {

	/**
	 * This method returns all sports as a list.
	 */
	public Sport getSportById(int id);
	public Sport getSportByName(String name, List<String> messages);
	public List<Sport> getAllSports(List<String> messages);
	public void addNew(Sport sport, List<String> messages);
	public void updateSport(Sport sport, List<String> messages);

}