package com.openHack.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openHack.io.entity.HackathonEntity;
import com.openHack.io.entity.UserEntity;
import com.openHack.io.repository.HackathonRepository;
import com.openHack.io.repository.UserRepository;
import com.openHack.service.HackathonService;
import com.openHack.shared.dto.HackathonDto;

@Service
public class HackathonServiceImpl implements HackathonService {

	@Autowired
	HackathonRepository hackathonRepository;
	
	@Autowired
	UserRepository userRepository;
	
	// Service method store hackathon object to database
	@Override
	public HackathonDto createHackthon(HackathonDto hackathonDto) {
		
		// DTO object to Entity object transfer
		HackathonEntity hackathonEntity = new HackathonEntity();
		
		hackathonEntity.setEventName(hackathonDto.getEventName());
		hackathonEntity.setDescription(hackathonDto.getDescription());
		hackathonEntity.setFee(hackathonDto.getFee());
		hackathonEntity.setMinTeamSize(hackathonDto.getMinTeamSize());
		hackathonEntity.setMaxTeamSize(hackathonDto.getMaxTeamSize());
		hackathonEntity.setJudges(hackathonDto.getJudges());
		
		hackathonEntity.setStartTime(Timestamp.valueOf(hackathonDto.getStartTime()));
		hackathonEntity.setEndTime(Timestamp.valueOf(hackathonDto.getEndTime()));
		
		List<String> judges = new ArrayList<>();
		for(int i = 0; i < hackathonDto.getJudges().size(); i++) 
			judges.add(hackathonDto.getJudges().get(i).getEmail());
	
		hackathonEntity.setJudges(null);
		for(int i = 0; i < judges.size(); i++) {
			UserEntity user =  userRepository.findByEmail(judges.get(i));
			hackathonEntity.addJudge(user);
		}
		
		// Repository method (save) to save HackathonEntity object to table hackathons
		HackathonEntity storedHackathonDetails = hackathonRepository.save(hackathonEntity);
				
		// returning the saved object to UI
		HackathonDto returnValue = new HackathonDto();
		
		returnValue.setId(storedHackathonDetails.getId());
		returnValue.setEventName(storedHackathonDetails.getEventName());
		returnValue.setDescription(storedHackathonDetails.getDescription());
		returnValue.setFee(storedHackathonDetails.getFee());
		returnValue.setMinTeamSize(storedHackathonDetails.getMinTeamSize());
		returnValue.setMaxTeamSize(storedHackathonDetails.getMaxTeamSize());
		
		returnValue.setStartTime(storedHackathonDetails.getStartTime().toString());
		returnValue.setEndTime(storedHackathonDetails.getEndTime().toString());
		
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
