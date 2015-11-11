package com.mycompany.service;

import java.util.List;

import com.mycompany.model.BetType;

public interface BetTypeService {

	public BetType getBetTypeById(int id);
	public abstract List<BetType> getAllBetTypes(List<String> messages);

}