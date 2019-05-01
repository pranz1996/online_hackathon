package com.openHack.io.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openHack.io.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{
	UserEntity findById(long id);
	UserEntity findByEmail(String email);
	
	@Query(value="select id from users u where u.email=?1", nativeQuery = true)
	UserEntity findUserByEmail(String email);
}
