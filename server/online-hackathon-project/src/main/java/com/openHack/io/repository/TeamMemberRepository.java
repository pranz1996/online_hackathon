package com.openHack.io.repository;

import com.openHack.io.entity.TeamMemberEntity;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMemberRepository extends CrudRepository<TeamMemberEntity, Long>
{
	@Transactional
	@Modifying
	@Query(value="delete from team_members where team_id = :id", nativeQuery = true)
	void deleteAllById(@Param("id") long id);
}
