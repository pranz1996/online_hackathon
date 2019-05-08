package com.openHack.io.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openHack.io.entity.OrganizationEntity;
import com.openHack.io.entity.UserEntity;

@Repository
public interface OrganizationRepository extends CrudRepository< OrganizationEntity, Long>{
	OrganizationEntity findById(long id);
	OrganizationEntity findByName(String name);
	
	@Query(value="select * from organizations o where o.owner_id=?1", nativeQuery = true)
	ArrayList<OrganizationEntity> findByOwnerId(long id);
	
	@Query(value="SELECT user_id FROM organization_join_request o where o.organization_id =?1", nativeQuery = true)
	ArrayList<Integer> getUserIds(long id);
}
