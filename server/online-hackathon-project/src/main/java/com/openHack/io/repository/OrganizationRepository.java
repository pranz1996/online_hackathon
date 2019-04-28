package com.openHack.io.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openHack.io.entity.OrganizationEntity;

@Repository
public interface OrganizationRepository extends CrudRepository< OrganizationEntity, Long>{
	OrganizationEntity findById(long id);
}
