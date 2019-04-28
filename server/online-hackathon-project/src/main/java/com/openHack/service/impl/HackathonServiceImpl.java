package com.openHack.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openHack.io.entity.HackathonEntity;
import com.openHack.io.repository.HackathonRepository;
import com.openHack.service.HackathonService;
import com.openHack.shared.dto.HackathonDto;

@Service
public class HackathonServiceImpl implements HackathonService {

	@Autowired
	HackathonRepository hackathonRepository;
	
	// Service method store hackathon object to database
	@Override
	public HackathonDto createHackthon(HackathonDto hackathonDto) {
		
		// DTO object to Entity object transfer
		HackathonEntity hackathonEntity = new HackathonEntity();
		BeanUtils.copyProperties(hackathonDto, hackathonEntity);
		
		// Repository method (save) to save HackathonEntity object to table hackathons
		HackathonEntity storedHackathonDetails = hackathonRepository.save(hackathonEntity);
		
		// returning the saved object to UI
		HackathonDto returnValue = new HackathonDto();
		BeanUtils.copyProperties(storedHackathonDetails, returnValue);
		
		return returnValue;
	}

	// Service method to get any hackathon based on it's id(primary key)
	@Override
	public HackathonDto getHackathonById(long id) {
		
		// returning object to UI
		HackathonDto returnValue = new HackathonDto();
		
		// Repository method (findById()) to fetch hackathon details
 		HackathonEntity hackathonEntity = hackathonRepository.findById(id);
		
 		// Entity object to DTO object transfer
		BeanUtils.copyProperties(hackathonEntity, returnValue);
		
		return returnValue;
	}

	@Override
	public HackathonDto updateHackathon(long id, HackathonDto hackathonDto) {
	
		// returning object to UI
		HackathonDto returnValue = new HackathonDto();
		
		// Repository method (findById()) to fetch hackathon details
		HackathonEntity hackathonEntity = hackathonRepository.findById(id);
		
		// updating the fields for hackathonEntity
		hackathonEntity.setDescription(hackathonDto.getDescription());
		hackathonEntity.setEventName(hackathonDto.getEventName());
		hackathonEntity.setFee(hackathonDto.getFee());
		hackathonEntity.setMinTeamSize(hackathonDto.getMinTeamSize());
		hackathonEntity.setMaxTeamSize(hackathonDto.getMaxTeamSize());
		
		// Repository method (save) to save updated HackathonEntity object to table hackathons
		HackathonEntity updateHackathon = hackathonRepository.save(hackathonEntity);
		BeanUtils.copyProperties(updateHackathon, returnValue);
	
		return returnValue;
	}

}
