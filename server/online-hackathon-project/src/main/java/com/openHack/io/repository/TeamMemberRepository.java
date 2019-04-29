package com.openHack.io.repository;

import com.openHack.io.entity.TeamMemberEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMemberRepository extends CrudRepository<TeamMemberEntity, Long>{
	TeamMemberEntity findById(long id);
}
