package com.mycompany.util;

import com.mycompany.model.Event;
import com.mycompany.model.formbackingobject.NewEvent;
import com.mycompany.service.SportService;

public interface EventTransformer {

	public Event generateEvent(NewEvent newEvent, SportService sportService);
}