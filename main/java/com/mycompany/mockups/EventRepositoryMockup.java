package com.mycompany.mockups;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.model.Event;
import com.mycompany.repository.CommonRepository;

public class EventRepositoryMockup implements CommonRepository<Event>{
	
	public List<Event> getAllEvents(){
		List<Event> events = new ArrayList<Event>();
		Event event;
		
		event = new Event();
		event.setId(1);
		event.setName("NHL");
		
		events.add(event);
		
		event = new Event();
		event.setId(2);
		event.setName("NBA");
		
		events.add(event);
		
		return	events; 
	}

	public Event getEvent(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Event getObjectById(Class<Event> c, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Event> getAllObjects(String query, Class<Event> c) {
		// TODO Auto-generated method stub
		return null;
	}

	public Event getObjectByName(String query, Class<Event> c, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addNew(Event object) {
		// TODO Auto-generated method stub
		
	}

	public void updateObject(Event object) {
		// TODO Auto-generated method stub
		
	}

}
