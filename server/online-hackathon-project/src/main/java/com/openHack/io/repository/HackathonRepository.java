package com.openHack.io.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openHack.io.entity.HackathonEntity;

@Repository
public interface HackathonRepository extends CrudRepository<HackathonEntity, Long>{
	HackathonEntity findById(long id);
	HackathonEntity findByEventName(String eventName);
	
}
