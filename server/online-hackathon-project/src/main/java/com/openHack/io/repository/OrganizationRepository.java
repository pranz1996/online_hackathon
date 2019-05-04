package com.openHack.io.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openHack.io.entity.OrganizationEntity;

@Repository
public interface OrganizationRepository extends CrudRepository< OrganizationEntity, Long>{
	OrganizationEntity findById(long id);
	OrganizationEntity findByName(String name);
	
	@Query(value="select * from organizations o where o.owner_id=?1", nativeQuery = true)
	OrganizationEntity findByOwnerId(long id);
}
