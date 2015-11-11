package com.mycompany.util;

import java.util.List;

import com.mycompany.model.BetType;
import com.mycompany.model.Sport;

public interface BetTypeHelper {

	/**
	 * This method returns bet types that are missing from specified sport.
	 * 
	 * @param sport		Sport to check.
	 * @return			List of missing sport types.
	 */
	public abstract List<BetType> getMissingBetTypes(Sport sport, List<String> messages);

}