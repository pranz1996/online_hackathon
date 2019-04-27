package com.openHack.service;

import com.openHack.shared.dto.HackathonDto;

public interface HackathonService {
	HackathonDto createHackthon(HackathonDto hackathonDto);
	HackathonDto getHackathonById(long id);
	HackathonDto updateHackathon(long id, HackathonDto hackathonDto);
}
