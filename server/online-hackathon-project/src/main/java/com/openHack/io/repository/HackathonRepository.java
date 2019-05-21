package com.openHack.io.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.openHack.io.entity.HackathonEntity;

@Repository
public interface HackathonRepository extends CrudRepository<HackathonEntity, Long>{
	HackathonEntity findById(long id);
	HackathonEntity findByEventName(String eventName);
	
	@Query(value="SELECT hackathon_id FROM judges j where j.judge_id =?1", nativeQuery = true)
	ArrayList<Long> getHackathonIds(long id);
	
	
	
}
