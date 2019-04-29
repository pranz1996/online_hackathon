package com.openHack.io.repository;

import com.openHack.io.entity.TeamEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<TeamEntity, Long>{
	TeamEntity findById(long id);
}
