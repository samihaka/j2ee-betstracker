package com.mycompany.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mycompany.model.Sport;
import com.mycompany.model.formbackingobject.NewEvent;
import com.mycompany.model.formbackingobject.NewSportBetType;
import com.mycompany.service.BetTypeService;
import com.mycompany.service.EventService;
import com.mycompany.service.SportService;
import com.mycompany.util.BetTypeHelper;
import com.mycompany.util.EventTransformer;
import com.mycompany.util.SportBetTypeTransformer;

@Controller
@SessionAttributes("messages")
public class SportsController {
	
	@Autowired
	private SportService sportService;
	
	@Autowired
	private EventService eventService;

	@Autowired
	private BetTypeService betTypeService;
	
	@Autowired
	private BetTypeHelper betTypeHelper;
	
	@Autowired
	private EventTransformer eventTransformer;
	
	@Autowired
	private SportBetTypeTransformer sportBetTypeTransformer;
	
	private List<String> messages = new ArrayList<String>();
	private String previousRequest;
	
	@RequestMapping(value="/sports", method=RequestMethod.GET)
	public String showPage(Model model){	
		List<Sport> sports;
		Sport newSport = new Sport();
		NewEvent newEvent = new NewEvent();
		NewSportBetType newSportBetType = new NewSportBetType();
		
		System.out.println("GET start");
		if(previousRequest != "GET" || previousRequest == null){
			previousRequest = "GET";
		}
		else{
			messages.clear();
		}
		
		sports = sportService.getAllSports(messages);
		
		model.addAttribute("sports", sports);
		model.addAttribute("newSport", newSport);
		model.addAttribute("newEvent", newEvent);
		model.addAttribute("newSportBetType", newSportBetType);		
		model.addAttribute("betTypeHelper", betTypeHelper);
		model.addAttribute("messages", messages);
		
		this.listModelContent("GET", model.asMap());

		return "sports";
	}
	
	@RequestMapping(value="/sports", params="add_sport", method=RequestMethod.POST)
	public String addSport(Model model, @ModelAttribute("newSport") Sport sport){
		previousRequest = "POST";

		System.out.println("POST add_sport start");
		
		sportService.addNew(sport, messages);
		
		this.listModelContent("POST", model.asMap());
		
		return "redirect:sports.html";
	}
	
	@RequestMapping(value="/sports", params="add_event", method=RequestMethod.POST)
	public String addEvent(Model model, @ModelAttribute("newEvent") NewEvent newEvent){
		previousRequest = "POST";

		System.out.println("POST add_event start");
		System.out.println(newEvent);
		eventService.addNew(eventTransformer.generateEvent(newEvent, sportService), messages);
		
		this.listModelContent("POST", model.asMap());
		
		return "redirect:sports.html";
	}
	
	@RequestMapping(value="/sports", params="add_sport_bettype", method=RequestMethod.POST)
	public String addSportBetType(Model model, @ModelAttribute("newSportBetType") NewSportBetType newSportBetType){
		previousRequest = "POST";

		System.out.println("POST add_sport_bettype start");
		System.out.println(newSportBetType);
		sportService.updateSport(sportBetTypeTransformer.generateSport(newSportBetType, sportService, betTypeService, messages), messages);
		
		this.listModelContent("POST", model.asMap());
		
		return "redirect:sports.html";
	}
		
	private void listModelContent(String method, Map<String, Object> modelMap){
		Iterator<Entry<String, Object>> i = modelMap.entrySet().iterator();
		
		System.out.println(method+":");
		
		while(i.hasNext()){
			Entry<String, Object> entry = (Entry<String, Object>)i.next();
			
			System.out.println(entry.getKey()+", "+entry.getValue());
		}
	}
}
