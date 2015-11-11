package com.mycompany.util;

import org.springframework.stereotype.Service;

import com.mycompany.model.Event;
import com.mycompany.model.formbackingobject.NewEvent;
import com.mycompany.service.SportService;

/**
 * This class is used to transform NewEvent class to Event class
 * 
 * @author Sami
 *
 */
@Service("eventTransformer")
public class EventTransformerImpl implements EventTransformer{
	
	public Event generateEvent(NewEvent newEvent, SportService sportService){
		Event event = new Event();
		
		event.setName(newEvent.getName());
		event.setSport(sportService.getSportById(newEvent.getSportId()));

		return event;
	}

}
