package com.mycompany.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.model.Sport;
import com.mycompany.model.exception.DBException;
import com.mycompany.repository.CommonRepository;

@Service("sportService")
public class SportServiceImpl implements SportService {
	
	@Autowired
	CommonRepository<Sport> sportRepository;
	
	public Sport getSportById(int id){
		return sportRepository.getObjectById(Sport.class, id);
	}
	
	public Sport getSportByName(String name, List<String> messages){
		Sport sport = new Sport();
	
		messages.clear();
		try{
			sport = sportRepository.getObjectByName(Sport.GET_SPORT_BY_NAME, Sport.class, name);
		}
		catch(DBException e){
			messages.add(e.getReason());
		}
		
		return sport;
	}
	
	public List<Sport> getAllSports(List<String> messages) {
		List<Sport> allSports = new ArrayList<Sport>();
		
		messages.clear();
		try{
			allSports = sportRepository.getAllObjects(Sport.GET_ALL_SPORTS, Sport.class);
		}
		catch(DBException e){
			messages.add(e.getReason());
		}
		
		return allSports;
	}

	@Transactional
	public void addNew(Sport sport, List<String> messages) {
		Sport existingSport = new Sport();
		
		existingSport = this.getSportByName(sport.getName(), messages);

		if(messages.get(0) == "error.no.result"){
			messages.add("msg.sport.added");
			sportRepository.addNew(sport);
		}

	}
	
	@Transactional
	public void updateSport(Sport sport, List<String> messages) {
		messages.clear();
		
		sportRepository.updateObject(sport);
	}
}
