package com.mycompany.util;

import java.util.List;

import com.mycompany.model.Sport;
import com.mycompany.model.formbackingobject.NewSportBetType;
import com.mycompany.service.BetTypeService;
import com.mycompany.service.SportService;

public interface SportBetTypeTransformer {

	public abstract Sport generateSport(NewSportBetType newSportBetType,
			SportService sportService, BetTypeService betTypeService, List<String> messages);

}