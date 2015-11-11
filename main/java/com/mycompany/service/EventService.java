package com.mycompany.service;

import java.util.List;

import com.mycompany.model.Event;

public interface EventService {

	public Event getEventById(int id);
	public List<Event> getAllEvents();
	public void addNew(Event event, List<String> messages);
}
