package com.mycompany.util;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycompany.model.Sport;
import com.mycompany.model.formbackingobject.NewSportBetType;
import com.mycompany.service.BetTypeService;
import com.mycompany.service.SportService;

@Service("sportBetTypeTransformer")
public class SportBetTypeTransformerImpl implements SportBetTypeTransformer {

	public Sport generateSport(NewSportBetType newSportBetType, SportService sportService, BetTypeService betTypeService, List<String> messages){
		Sport sport = sportService.getSportByName(newSportBetType.getSportName(), messages);
		
		sport.getBetTypes().add(betTypeService.getBetTypeById(newSportBetType.getBetTypeId()));
		
		return sport;
		
	}
}
