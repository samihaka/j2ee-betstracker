package com.mycompany.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.model.Event;
import com.mycompany.model.exception.DBException;
import com.mycompany.repository.CommonRepository;

@Service("eventService")
public class EventServiceImpl implements EventService{
	
	@Autowired
	private CommonRepository<Event> eventRepository;
	
	public Event getEventById(int id){
		return eventRepository.getObjectById(Event.class, id);
	}
	
	/**
	 * This method returns all events as a list.
	 */
	public List<Event> getAllEvents() {
		
		return null;
	}

	@Transactional
	public void addNew(Event event, List<String> messages) {
		Event existingEvent;
		
		try{
			existingEvent = eventRepository.getObjectByName(Event.GET_EVENT_BY_NAME, Event.class, event.getName());

			messages.clear();
			if(existingEvent != null){
				messages.add("error.event.already_exists");
			}
			else{
				messages.add("msg.event.added");
				eventRepository.addNew(event);	
			}
		}
		catch (DBException e){
			messages.add(e.getReason());
		}
		
	}
}
