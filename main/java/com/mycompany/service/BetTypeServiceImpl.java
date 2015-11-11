package com.mycompany.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.model.BetType;
import com.mycompany.model.exception.DBException;
import com.mycompany.repository.CommonRepository;

@Service("betTypeService")
public class BetTypeServiceImpl implements BetTypeService {

	@Autowired
	CommonRepository<BetType> betTypeRepository;;
	
	public BetType getBetTypeById(int id){
		return betTypeRepository.getObjectById(BetType.class, id);
	}
	
	public List<BetType> getAllBetTypes(List<String> messages) {
		List<BetType> allBetTypes = new ArrayList<BetType>();
		
		try{
			allBetTypes = betTypeRepository.getAllObjects(BetType.GET_ALL_BET_TYPES, BetType.class);
		}
		catch(DBException e){
			messages.add(e.getReason());
		}
		
		return allBetTypes;
	}
}
