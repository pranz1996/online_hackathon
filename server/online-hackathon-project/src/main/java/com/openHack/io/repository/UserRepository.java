package com.openHack.io.repository;

import org.springframework.data.repository.CrudRepository;

import com.openHack.io.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long>{
	UserEntity findById(long id);
}
