package com.mycompany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BetsController {
		
	@RequestMapping(value="/bets", method=RequestMethod.GET)
	public String showPage(){	
		return "bets";
	}
}