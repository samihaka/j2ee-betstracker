package com.mycompany.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.model.BetType;
import com.mycompany.service.BetTypeService;

@Controller
public class BetTypesController {

	@Autowired
	private BetTypeService betTypesService;
	
	private List<String> messages = new ArrayList<String>();
	
	@RequestMapping(value="/bettypes", method=RequestMethod.GET)
	public String showPage(Model model){	
		List<BetType> betTypes;
		
		betTypes = betTypesService.getAllBetTypes(messages);
		
		model.addAttribute("betTypes", betTypes);
		model.addAttribute("messages", messages);
		
		return "bettypes";
	}
}
