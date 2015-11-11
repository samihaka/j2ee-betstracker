package com.mycompany.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.model.BetType;
import com.mycompany.model.Sport;
import com.mycompany.service.BetTypeService;

@Service("betTypeHelper")
public class BetTypeHelperImpl implements BetTypeHelper {
	
	@Autowired
	private BetTypeService betTypeService;
	
	/**
	 * This method returns bet types that are missing from specified sport.
	 * 
	 * @param sport		Sport to check.
	 * @return			List of missing sport types.
	 */
	public List<BetType> getMissingBetTypes(Sport sport, List<String> messages){
		List<BetType> missingBetTypes = betTypeService.getAllBetTypes(messages);
		
		missingBetTypes.removeAll(sport.getBetTypes());
		
		return missingBetTypes;
	}
}
